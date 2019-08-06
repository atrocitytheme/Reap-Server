package server.reaptheflag.reaptheflag.gameserver.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.CommandType;
import server.reaptheflag.reaptheflag.gameserver.model.logic.KeyFrame;
import server.reaptheflag.reaptheflag.gameserver.model.logic.TimeoutFrame;
import server.reaptheflag.reaptheflag.gameserver.network.manager.BatchProcessFrame;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;

@Configuration
@EnableScheduling
public class FrameBroadCastConfigration {
    private static Logger LOGGER = LogManager.getLogger(FrameBroadCastConfigration.class);
    private BatchProcessFrame machine1;
    private NetworkSpace space;
    // frame synchronization to the players
    @Scheduled(fixedRate = 33)
    public void frameworkUpdate() {
        machine1.batchProcess(space);
    }
    /**
     * Check if the room has outdated, 4 minutes is the limit
     * */
    @Scheduled(cron = "*/30 * * * * ?")
    public void timeoutUpdate() {
        space.getAllRooms().parallelStream().forEach((r) -> {
            r.decrementTime();
            if (!r.isRoomValid()) {
                KeyFrame frame = new KeyFrame();
                frame.setCommandType(CommandType.FORCE_EXIT.commandType());
                r.writeFrameToAll(frame);
                space.removeRoom(r);
                LOGGER.info("room: " + r.getRoomId() + " has been removed for timeout");
            }

            else {
                TimeoutFrame frame = new TimeoutFrame();
                frame.setCommandType(CommandType.SYNC_TIME.commandType());
                frame.setTimeLeft(r.getLastingTime() * 30);
                r.writeFrameToAll(frame);
            }
        });
    }

    @Autowired
    public void setMachine1(BatchProcessFrame machine1) {
        this.machine1 = machine1;
    }

    @Autowired
    public void setSpace(NetworkSpace space) {
        this.space = space;
    }
}
