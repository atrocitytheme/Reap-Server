package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkLocationUser;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.rooms.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.network.rooms.NetworkSpace;

/**
 * TODO: make the broadcast of player movement
 * */
public class PlayerMoveCommand implements Command{
    private static Logger LOGGER = LogManager.getLogger(PlayerMoveCommand.class);
    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        LOGGER.info("playermove command exceeds!");
        NetworkLocationUser user = new NetworkLocationUser((UdpClientUser) client);

        OnlinePlayer model = user.generateModel();
        NetworkRoom room = space.getRoom(user.getRoom());

        if (!room.contains(user)) {
            room.addPlayer(user, model);
        }

        else {
            room.update(user, model);
        }
    }
}
