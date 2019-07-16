package server.reaptheflag.reaptheflag.udpserver.Handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.udpserver.dispatcher.marker.CommandType;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;

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