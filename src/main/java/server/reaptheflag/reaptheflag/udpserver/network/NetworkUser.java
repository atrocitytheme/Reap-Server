package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.network.sendable.SendableData;

public interface NetworkUser {
    int commandType();
    String getIp();
    String getName();
    void broadcast(SendableData data);
    String getToken();
}
