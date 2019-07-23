package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.marker.CommandType;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;

/**
 * This is a command of invalid usage
 * */

@CommandType
public class NullCommand implements Command{

    private static Logger LOGGER = LogManager.getLogger(NullCommand.class);

    @Override
    public void execute(NetworkUser client, NetworkSpace space) {

        LOGGER.info(client + "is triggering null command!");
    }
}