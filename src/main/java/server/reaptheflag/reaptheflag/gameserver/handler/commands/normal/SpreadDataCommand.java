package server.reaptheflag.reaptheflag.gameserver.handler.commands.normal;

import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.game.modes.normal.NormalRoom;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public class SpreadDataCommand implements Command {

    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        NormalRoom room = (NormalRoom) space.getRoom(client);
        room.broadRoomDataToUser(client);
    }
}
