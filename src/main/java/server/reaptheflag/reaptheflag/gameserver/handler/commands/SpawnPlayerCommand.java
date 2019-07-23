package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
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
        String id = UUID.randomUUID().toString();  // generic threadsafe

        NetworkSpawnUser user = new NetworkSpawnUser((UdpClientUser) client);

        OnlinePlayer model = user.generateModel();
        model.setId(id);
        NetworkRoom room = space.getRoom(1); // choose the room they're able to join
        room.addPlayer(user, model);
    }
}
