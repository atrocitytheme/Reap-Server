package server.reaptheflag.reaptheflag.renderserver.Handler.commands;

import server.reaptheflag.reaptheflag.renderserver.network.Client;

public interface Command {
    void execute(Client client);
}
