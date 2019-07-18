package server.reaptheflag.reaptheflag.udpserver.network.broadcast;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.udpserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkRoom;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.udpserver.network.sendable.SentDataPacketUdp;

import java.util.Collection;
import java.util.Set;

@Service
public class BatchBroadcaster {

    private BroadcastClientMachine machine1;
    private static Logger LOGGER = LogManager.getLogger(BatchBroadcaster.class);

    public void broadCast(NetworkSpace space) {
        LOGGER.info("broadcasting... to the client");
        space.getAllRooms().parallelStream().forEach((r) -> {
            this.fastBroadCast(r);
        });
    }
    // quickly broadcast to all rooms
    public void fastBroadCast(NetworkRoom r) {
        Collection<? extends OnlineObject> obj = r.getAllObjects();
        Set<NetworkUser> allUsers = r.getAllUsers();
        SentDataPacketUdp data = new SentDataPacketUdp(obj);
        allUsers.parallelStream().forEach((u) -> {
            machine1.broadCast(u, data);
        });
    }

    @Autowired
    public void setMachine1(BroadcastClientMachine machine1) {
        this.machine1 = machine1;
    }
}
