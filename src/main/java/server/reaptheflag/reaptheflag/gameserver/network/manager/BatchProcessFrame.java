package server.reaptheflag.reaptheflag.gameserver.network.manager;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.manager.broadcast.BroadcastClientMachine;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.SentDataPacketUdp;

import java.util.Collection;
import java.util.Set;
/**
 * This is the frame for process the whole space in batch in frame updates
 * */
@Service
public class BatchProcessFrame {

    private BroadcastClientMachine broadcastMachine1;

    private TimeoutManager managerMacnhine1;


    private ConnectionManager connectionMachine1;
    private static Logger LOGGER = LogManager.getLogger(BatchProcessFrame.class);

    public void batchProcess(NetworkSpace space) {
        LOGGER.info("broadcasting... to the client");
        space.getAllRooms().parallelStream().forEach((r) -> {
            this.fastProcess(r);
        });
    }
    // quickly broadcast to all rooms
    public void fastProcess(NetworkRoom r) {
        Collection<? extends OnlineObject> obj = r.getAllObjects();
        Set<NetworkUser> allUsers = r.getAllUsers();
        SentDataPacketUdp data = new SentDataPacketUdp(obj);
        allUsers.parallelStream().forEach((u) -> {
            // TODO: add a room processor bean in sequence
            r.get(u).setToken("me");

            broadcastMachine1.broadCast(u, data);
            r.get(u).setToken("othre");

            managerMacnhine1.manageTimeout(u);
            connectionMachine1.manageConnection(u);
        });
    }

    @Autowired
    public void setBroadcastMachine1(BroadcastClientMachine broadcastMachine1) {
        this.broadcastMachine1 = broadcastMachine1;
    }

    @Autowired
    public void setManagerMacnhine1(TimeoutManager managerMacnhine1) {
        this.managerMacnhine1 = managerMacnhine1;
    }
    @Autowired
    public void setConnectionMachine1(ConnectionManager connectionMachine1) {
        this.connectionMachine1 = connectionMachine1;
    }
}
