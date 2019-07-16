package server.reaptheflag.reaptheflag.renderserver.Handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.renderserver.dispatcher.marker.CommandType;
import server.reaptheflag.reaptheflag.renderserver.network.NetworkUser;

/**
 * This is a command of invalid usage
 * */

@CommandType
public class NullCommand implements Command{

    private static Logger LOGGER = LogManager.getLogger(NullCommand.class);

    @Override
    public void execute(NetworkUser client) {
        LOGGER.info(client);
    }
}