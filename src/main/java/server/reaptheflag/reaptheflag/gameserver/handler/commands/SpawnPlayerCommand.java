package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.model.scene.WorldPoint;
import server.reaptheflag.reaptheflag.gameserver.model.scene.location.Location;
import server.reaptheflag.reaptheflag.gameserver.network.udp.SpawnUser;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;

public class SpawnPlayerCommand implements Command{
    private static Logger LOGGER = LogManager.getLogger(SpawnPlayerCommand.class);
    public void execute(NetworkUser client, NetworkSpace space) {
        LOGGER.info("playerspawn command exceeds!");
        SpawnUser user = new SpawnUser((UdpClientUser) client);
        OnlinePlayer model = user.generateModel();
        model.setId(user.getId());
        Location lo = new Location();
        lo.setLocation(new WorldPoint(1, 2, 3));
        model.setLocation(lo);
        NetworkRoom room = space.getRoom(user.getRoom()); // choose the room they're able to join
        room.addUdpInfo(user, model);
    }
}
