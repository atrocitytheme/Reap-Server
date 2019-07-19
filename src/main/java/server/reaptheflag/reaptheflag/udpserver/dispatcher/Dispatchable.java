package server.reaptheflag.reaptheflag.udpserver.dispatcher;

import server.reaptheflag.reaptheflag.udpserver.dispatcher.udp.PacketDispatcher;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;

public interface Dispatchable {
    void dispatch(PacketDispatcher handler, NetworkUser client);
}
