package server.reaptheflag.reaptheflag.gameserver.dispatcher;

import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.NullCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.PlayerMoveCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.rooms.NetworkSpace;

/**
 * check which command to process for this player
 * */

@Component
public class CommandDispatchHelper {
    public Command takeCommand(NetworkUser user, NetworkSpace space) {
        if (user.getRoom() == -1) {
            return new NullCommand();
        }

        if (space.getRoom(user.getRoom()) == null) return new NullCommand();

        if (!space.getRoom(user.getRoom()).contains(user) && user.commandType() != 1) {
            return new NullCommand();
        }

        if (user.commandType() == 1) {
            return new PlayerMoveCommand();
        }

        return new PlayerMoveCommand();
    }
}
