package server.reaptheflag.reaptheflag.udpserver.handler.commands;

import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

public interface Command {
    void execute(NetworkUser client, NetworkSpace space);
}
