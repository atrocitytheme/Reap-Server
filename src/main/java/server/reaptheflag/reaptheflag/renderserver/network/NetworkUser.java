package server.reaptheflag.reaptheflag.renderserver.network;

public interface NetworkUser {
    int commandType();
    String getIp();
    void broadcast();
}
