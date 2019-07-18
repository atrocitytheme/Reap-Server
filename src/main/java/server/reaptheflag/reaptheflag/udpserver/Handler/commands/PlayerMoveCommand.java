package server.reaptheflag.reaptheflag.udpserver.Handler.commands;

import server.reaptheflag.reaptheflag.udpserver.network.UdpClient;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkRoom;

/**
 * TODO: make the broadcast of player movement
 * */
public class PlayerMoveCommand implements Command{
    @Override
    public void execute(NetworkUser client, NetworkRoom room) {
        UdpClient onlinePlayreConnction = (UdpClient) client;

    }
}
