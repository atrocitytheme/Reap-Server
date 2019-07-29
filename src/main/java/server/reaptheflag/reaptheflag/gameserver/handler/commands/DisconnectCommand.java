package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
/**
 * tcp exclusive command, cut the KKEP-ALIVE connection of the user
 * */
public class DisconnectCommand implements Command{

    private static Logger LOGGER = LogManager.getLogger(DisconnectCommand.class);
    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        client.disconnect();
    }
}
