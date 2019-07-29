package server.reaptheflag.reaptheflag.gameserver.dispatcher.tcp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.DisconnectCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.NullCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

@Component
public class TcpCommandDispatcherHelper {
    private static Logger LOGGER = LogManager.getLogger(TcpCommandDispatcherHelper.class);
    public Command taleCommand(NetworkUser user, NetworkSpace space) {

        if (user.commandType() == 101) {
            LOGGER.info(user.rawAddress() + " is testing this connection");
            return new NullCommand();
        }

        if (space.getRoom(user.getRoom()) == null) {
            LOGGER.info(user + "  invalid tcp command detected");
            return new DisconnectCommand();
        }
        // if not in this room
        if (!space.getRoom(user.getRoom()).exists(user)) {
            LOGGER.info(user + " tcp requests: want to hack into this room with id: " + user.getRoom());
            return new DisconnectCommand();
        }

        LOGGER.info("haha");
        return new NullCommand();
    }

}
