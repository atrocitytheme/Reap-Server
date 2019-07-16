package server.reaptheflag.reaptheflag.udpserver.network;

public interface NetworkUser {
    int commandType();
    String getIp();
    void broadcast();
}
