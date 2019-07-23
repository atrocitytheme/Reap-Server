package server.reaptheflag.reaptheflag.gameserver.dispatcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.NullCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.PlayerMoveCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.SpawnPlayerCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;

/**
 * check which command to process for this player
 * */

@Component
public class CommandDispatchHelper {
    private static Logger LOGGER = LogManager.getLogger(CommandDispatchHelper.class);
    public Command takeCommand(NetworkUser user, NetworkSpace space) {
        // if the input room is invalid
        if (space.getRoom(user.getRoom()) == null) {
            LOGGER.info("The room doesn't exist!");
            return new NullCommand();
        }
        // if not in this room
        if (user.commandType() != 0 && !space.getRoom(user.getRoom()).contains(user)) {
            LOGGER.info(user + "is not in this room");
            return new NullCommand();
        }
        // if this goes without valid token
        if (user.commandType() != 0 && !space.getRoom(user.getRoom()).checkId(user)) {
            LOGGER.info("user: " + user + " is trying to hack this room" + user.getRoom());
            return new NullCommand();
        }

       /* if (user.commandType() == 0 && space.getRoom(user.getRoom()).contains(user)) {
            LOGGER.info(user + " has already been spawned!");
            return new NullCommand();
        }*/

        if (user.commandType() == 0 ) {
            return new SpawnPlayerCommand();
        }

        if (user.commandType() == 1) {
            return new PlayerMoveCommand();
        }

        return new NullCommand();
    }
}
