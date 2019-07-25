package server.reaptheflag.reaptheflag.gameserver.dispatcher;

import server.reaptheflag.reaptheflag.gameserver.dispatcher.udp.PacketDispatcher;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public interface Dispatchable {
    void dispatch(ProtocalDetectable handler, NetworkUser client);
}
