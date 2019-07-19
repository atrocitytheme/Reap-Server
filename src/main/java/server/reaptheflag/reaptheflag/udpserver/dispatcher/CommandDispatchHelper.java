package server.reaptheflag.reaptheflag.udpserver.dispatcher;

import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.udpserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.udpserver.handler.commands.NullCommand;
import server.reaptheflag.reaptheflag.udpserver.handler.commands.PlayerMoveCommand;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

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

        return new PlayerMoveCommand();
    }
}
