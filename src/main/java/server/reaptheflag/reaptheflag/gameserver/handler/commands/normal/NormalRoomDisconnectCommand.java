package server.reaptheflag.reaptheflag.gameserver.handler.commands.normal;

import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.game.modes.normal.NormalRoom;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.DisconnectCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public class NormalRoomDisconnectCommand extends DisconnectCommand {

    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        super.execute(client, space);
        NormalRoom room = (NormalRoom) space.getRoom(client);
        room.exitPlayer(client);
    }
}
