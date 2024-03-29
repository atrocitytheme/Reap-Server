package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.network.udp.LocationUser;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;

/**
 * TODO: make the broadcast of player movement
 * */
public class PlayerMoveCommand implements Command{
    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        LocationUser user = new LocationUser((UdpClientUser) client);
        OnlinePlayer model = user.generateModel();
        model.setId(user.getId());
        NetworkRoom room = space.getRoom(user.getRoom());
        room.updateUdpInfo(user, model);
    }
}
