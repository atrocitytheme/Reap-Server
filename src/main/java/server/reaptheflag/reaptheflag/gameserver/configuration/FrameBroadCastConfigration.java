package server.reaptheflag.reaptheflag.gameserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import server.reaptheflag.reaptheflag.gameserver.network.manager.BatchProcessFrame;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;

@Configuration
@EnableScheduling
public class FrameBroadCastConfigration {
    private BatchProcessFrame machine1;
    private NetworkSpace space;
    // frame synchronization
    @Scheduled(cron = "* * * * * *")
    public void frameworkUpdate() {
        space.update();
        machine1.batchProcess(space);
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
