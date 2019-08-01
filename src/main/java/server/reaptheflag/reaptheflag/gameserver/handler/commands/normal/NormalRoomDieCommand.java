package server.reaptheflag.reaptheflag.gameserver.handler.commands.normal;

import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.game.modes.normal.NormalRoom;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.DieCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.TcpClientUser;

public class NormalRoomDieCommand extends DieCommand {

    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        super.execute(client, space);
        NormalRoom room = (NormalRoom) space.getRoom(client.getRoom());
        TcpClientUser user = (TcpClientUser) client;
        room.die(client, user.getEventTrigger());
    }
}
