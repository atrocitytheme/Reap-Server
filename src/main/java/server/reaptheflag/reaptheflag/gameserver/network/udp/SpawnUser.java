package server.reaptheflag.reaptheflag.gameserver.network.udp;

import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.model.scene.location.Location;
import server.reaptheflag.reaptheflag.gameserver.model.scene.rotation.Rotation;
import server.reaptheflag.reaptheflag.gameserver.network.Configurable;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;

public class SpawnUser extends UdpClientUser implements Configurable {
    public SpawnUser(UdpClientUser user) {
        super(user.getNetworkPacket());
        setTimeout(user.getTimeout());
    }

    public OnlinePlayer generateModel() {
        OnlinePlayer model = new OnlinePlayer();
        configureModel(model);
        return model;
    }

    @Override
    public void configureModel(OnlineObject obj) {
        OnlinePlayer model = (OnlinePlayer) obj;
        model.setCommandType(0);
        model.setId(getId());
        model.setRoomId(getRoom());
        model.setToken("other");
        model.setPort(getPort());
        model.setIp(getIp());
        model.setLocation(new Location());
        model.setRotation(new Rotation());
    }
}
