package server.reaptheflag.reaptheflag.gameserver.dispatcher;

import server.reaptheflag.reaptheflag.gameserver.dispatcher.udp.PacketDispatcher;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
/**
 * Dispatchable is mainly used for implementing general dispatch layer of the server,
 * this layer detects the type of the request (p.s: the protocal) and assign it to different command handler
 * */
public interface Dispatchable {
    /**
     * Api for redirecting the request to the next layer (command dispatcher layer)
     * */
    void dispatch(ProtocalDetectable handler, NetworkUser client);
}
