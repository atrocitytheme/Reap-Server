package server.reaptheflag.reaptheflag.renderserver.Handler.commands;

import server.reaptheflag.reaptheflag.renderserver.network.NetworkUser;

public interface Command {
    void execute(NetworkUser client);
}
