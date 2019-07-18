package server.reaptheflag.reaptheflag.udpserver.Handler.commands;

import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkRoom;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

public interface Command {
    void execute(NetworkUser client, NetworkSpace space);
}
