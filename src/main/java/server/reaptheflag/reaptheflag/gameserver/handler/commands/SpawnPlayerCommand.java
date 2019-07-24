package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.model.scene.WorldPoint;
import server.reaptheflag.reaptheflag.gameserver.model.scene.location.Location;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkSpawnUser;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;

import java.util.UUID;

public class SpawnPlayerCommand implements Command{
    private static Logger LOGGER = LogManager.getLogger(SpawnPlayerCommand.class);
    public void execute(NetworkUser client, NetworkSpace space) {
        LOGGER.info("playerspawn command exceeds!");
        NetworkSpawnUser user = new NetworkSpawnUser((UdpClientUser) client);
        OnlinePlayer model = user.generateModel();
        model.setId(user.getId());
        Location lo = new Location();
        lo.setLocation(new WorldPoint(1, 2, 3));
        model.setLocation(lo);
        NetworkRoom room = space.getRoom(user.getRoom()); // choose the room they're able to join
        room.addUdpInfo(user, model);
    }
}
