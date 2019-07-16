package server.reaptheflag.reaptheflag.renderserver.dispatcher;

import server.reaptheflag.reaptheflag.renderserver.Handler.PacketHandler;
import server.reaptheflag.reaptheflag.renderserver.network.NetworkUser;

public interface Dispatchable {
    void dispatch(PacketHandler handler, NetworkUser client);
}
