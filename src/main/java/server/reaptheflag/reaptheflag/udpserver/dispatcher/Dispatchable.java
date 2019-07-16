package server.reaptheflag.reaptheflag.udpserver.dispatcher;

import server.reaptheflag.reaptheflag.udpserver.Handler.PacketHandler;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;

public interface Dispatchable {
    void dispatch(PacketHandler handler, NetworkUser client);
}
