package server.reaptheflag.reaptheflag.gameserver.dispatcher.tcp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.*;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

@Component
public class TcpCommandDispatcherHelper {
    private static Logger LOGGER = LogManager.getLogger(TcpCommandDispatcherHelper.class);
    public Command taleCommand(NetworkUser user, NetworkSpace space) {

        if (space.getRoom(user.getRoom()) == null) {
            LOGGER.info(user + "  invalid tcp command detected");
            return new DisconnectCommand();
        }

        NetworkRoom room = space.getRoom((user.getRoom()));
        // if not in this room
        if (!room.exists(user)) {
            LOGGER.info(user + " tcp requests: want to hack into this room with id: " + user.getRoom());
            return new DisconnectCommand();
        }

        if (user.commandType() == 101) {
            LOGGER.info(user.rawAddress() + " is testing connection");
            return new ConnectionCommand();
        }

        if (user.commandType() == 6) {
            LOGGER.info("player dies!");
            return new DieCommand();
        }

        LOGGER.info("haha");
        return new NullCommand();
    }

}
