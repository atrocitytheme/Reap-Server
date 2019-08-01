package server.reaptheflag.reaptheflag.gameserver.handler.commands.normal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.game.modes.normal.NormalRoom;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.DisconnectCommand;
import server.reaptheflag.reaptheflag.gameserver.model.logic.KeyFrame;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public class NormalRoomDisconnectCommand extends DisconnectCommand {
    private static Logger LOGGER = LogManager.getLogger(NormalRoomDisconnectCommand.class);
    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        LOGGER.info(client + " disconnect from the room: " + client.getRoom());
        super.execute(client, space);
        NormalRoom room = (NormalRoom) space.getRoom(client);
        room.disconnect(client);
    }
}
