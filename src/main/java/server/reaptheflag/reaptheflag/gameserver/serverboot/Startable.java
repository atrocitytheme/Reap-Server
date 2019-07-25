package server.reaptheflag.reaptheflag.gameserver.serverboot;

public interface Startable {
    void run() throws Exception;
    String getName();
}
