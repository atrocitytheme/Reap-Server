package server.reaptheflag.reaptheflag.gameserver.network.manager.broadcast;

import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.SendableData;
/**
 * machine that sends the data to the client destination
 * */
public abstract class BroadcastClientMachine {
    public abstract void broadCast(NetworkUser client, SendableData data);
}
