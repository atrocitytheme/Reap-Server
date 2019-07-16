package server.reaptheflag.reaptheflag.renderserver.Handler.commands;

import server.reaptheflag.reaptheflag.renderserver.dispatcher.marker.CommandType;
import server.reaptheflag.reaptheflag.renderserver.network.Client;

/**
 * This is a command of invalid usage
 * */

@CommandType
public class NullCommand implements Command{

    @Override
    public void execute(Client client) {
        System.out.println(client);
    }
}