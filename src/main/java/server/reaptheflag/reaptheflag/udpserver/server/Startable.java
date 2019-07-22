package server.reaptheflag.reaptheflag.udpserver.server;

public interface Startable {
    void run() throws Exception;
    String getName();
}
