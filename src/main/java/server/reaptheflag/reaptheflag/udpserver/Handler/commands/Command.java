package server.reaptheflag.reaptheflag.udpserver.Handler.commands;

import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;

public interface Command {
    void execute(NetworkUser client);
}
