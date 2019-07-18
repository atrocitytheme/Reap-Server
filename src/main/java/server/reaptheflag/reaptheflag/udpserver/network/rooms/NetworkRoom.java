package server.reaptheflag.reaptheflag.udpserver.network.rooms;

import ch.qos.logback.core.net.server.Client;
import server.reaptheflag.reaptheflag.udpserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.udpserver.network.sendable.SendableData;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NetworkRoom {
    private ConcurrentHashMap<Client, OnlineObject> datas = new ConcurrentHashMap<>();
    /**
     * update the room status
     * */
    public void update(Client newClient) {

    }
}
