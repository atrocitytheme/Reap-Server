package server.reaptheflag.reaptheflag.gameserver.server;

public interface Startable {
    void run() throws Exception;
    String getName();
}
