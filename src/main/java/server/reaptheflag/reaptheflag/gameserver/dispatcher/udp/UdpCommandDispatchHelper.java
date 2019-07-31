package server.reaptheflag.reaptheflag.gameserver.dispatcher.udp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.NullCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.PlayerMoveCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.SpawnPlayerCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;

/**
 * check which command to process for this player
 * */

@Component
public class UdpCommandDispatchHelper {
    private static Logger LOGGER = LogManager.getLogger(UdpCommandDispatchHelper.class);
    public Command takeCommand(NetworkUser user, NetworkSpace space) {
        // if the input room is invalid
        if (space.getRoom(user.getRoom()) == null) {
            LOGGER.info(user + " is trying to join a room doesn't exist!");
            return new NullCommand();
        }
        // if not in this room
        if (!space.getRoom(user.getRoom()).exists(user)) {
            LOGGER.info(user + " want to hack into this room: " + user.getRoom());
            return new NullCommand();
        }

        if (user.commandType() == 0 ) {
            return new SpawnPlayerCommand();
        }

        if (user.commandType() == 1) {
            return new PlayerMoveCommand();
        }
        // ob mode
        if (user.commandType() == 10) {
            return new PlayerMoveCommand();
        }

        return new NullCommand();
    }
}
