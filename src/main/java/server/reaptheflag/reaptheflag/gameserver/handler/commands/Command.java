package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.rooms.NetworkSpace;

public interface Command {
    void execute(NetworkUser client, NetworkSpace space);
}
