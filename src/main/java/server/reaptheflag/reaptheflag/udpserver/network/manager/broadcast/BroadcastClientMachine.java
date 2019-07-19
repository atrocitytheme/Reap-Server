package server.reaptheflag.reaptheflag.udpserver.network.manager.broadcast;

import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.sendable.SendableData;
/**
 * machine that sends the data to the client destination
 * */
public abstract class BroadcastClientMachine {
    public abstract void broadCast(NetworkUser client, SendableData data);
}
