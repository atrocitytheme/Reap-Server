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
import server.reaptheflag.reaptheflag.gameserver.network.sendable.SafePacketSentData;
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
    // batch process for all the scenes
    public void batchProcess(NetworkSpace space) {
        space.getAllRooms().parallelStream().forEach((r) -> {
            /*this.fastProcess(r);*/
            this.fastProcess(r);
        });
    }

    @Deprecated
    public void safeProcess(NetworkRoom r) {
        Collection<? extends OnlineObject> obj = r.getAllUdpObjects();
        Set<NetworkUser> allUsers = r.getAllUdpUsers();

        allUsers.parallelStream().forEach((u) -> {
            SafePacketSentData data = new SafePacketSentData(obj);
            broadcastMachine1.broadCast(u, data);
            managerMacnhine1.manageTimeout(u);
            connectionMachine1.manageConnection(u);
        });

    }
    // quickly broadcast to all rooms without any verifcation, later used for rendering sceneObjects
    // this method is unsafe
    public void fastProcess(NetworkRoom r) {
        Collection<? extends OnlineObject> obj = r.getAllUdpObjects();
        Set<NetworkUser> allUsers = r.getAllUdpUsers();
        SentDataPacketUdp data = new SentDataPacketUdp(obj);
        allUsers.parallelStream().forEach((u) -> {
            // TODO: add a room processor bean in sequence
            // TODO: since this is a multithread env, this requries token sync, implement this in somewhere else

            broadcastMachine1.broadCast(u, data);
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
