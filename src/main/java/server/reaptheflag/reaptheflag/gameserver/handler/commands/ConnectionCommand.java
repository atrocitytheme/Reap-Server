package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import server.reaptheflag.reaptheflag.gameserver.game.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public class ConnectionCommand implements Command {
    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
         NetworkRoom room = space.getRoom(client.getRoom());

         //TODO: solve the update problem
        room.updateTcpInfo(client, new OnlineObject());
        /*TcpClientUser tcpUser = (TcpClientUser) client;
        tcpUser.getNetworkCondition().writeAndFlush("test message");*/
    }
}
