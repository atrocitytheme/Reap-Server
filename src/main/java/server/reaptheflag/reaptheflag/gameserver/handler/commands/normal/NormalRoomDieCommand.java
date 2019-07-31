package server.reaptheflag.reaptheflag.gameserver.handler.commands.normal;

import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.game.modes.NormalRoom;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.DieCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public class NormalRoomDieCommand extends DieCommand {

    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        super.execute(client, space);
        NormalRoom room = (NormalRoom) space.getRoom(client.getRoom());
        room.die(client);
    }
}
