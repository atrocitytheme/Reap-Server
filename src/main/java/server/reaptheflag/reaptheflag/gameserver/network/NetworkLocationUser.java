package server.reaptheflag.reaptheflag.gameserver.network;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.model.scene.WorldPoint;
import server.reaptheflag.reaptheflag.gameserver.model.scene.location.Location;
import server.reaptheflag.reaptheflag.gameserver.model.scene.rotation.Rotation;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.parser.JsonFormatParser;

/**
 * a higher level wrap of class to manipulate the network requests
 * */
public class NetworkLocationUser extends UdpClientUser implements Configurable{

    public Location getLocation() {
        JsonFormatParser<OnlinePlayer> parser = packet.content();
        // TODO: location is correct, but pt becomes 0 after transformed
        JsonElement location = parser.getGsonElementByName("Location");
        JsonElement e = parser.getGsonElementByName("Location", location);
        double x = parser.getDoubleByName("X", e);
        double y = parser.getDoubleByName("Y", e);
        double z = parser.getDoubleByName("Z", e);
        WorldPoint pt = new WorldPoint(x, y, z);
        Location res = new Location();
        res.setLocation(pt);

        return res;
    }

    public Rotation getRotation() {
        JsonFormatParser<OnlinePlayer> parser = packet.content();
        JsonElement rotation = parser.getGsonElementByName("Rotation");
        JsonElement e = parser.getGsonElementByName("Rotation", rotation);
        double x = parser.getDoubleByName("X", e);
        double y = parser.getDoubleByName("Y", e);
        double z = parser.getDoubleByName("Z", e);
        Rotation pt = new Rotation(x, y, z);

        return pt;
    }

    public NetworkLocationUser(UdpClientUser user) {
        super(user.getNetworkPacket());
        setTimeout(user.getTimeout());
    }

    public OnlinePlayer generateModel() {
        OnlinePlayer model = new OnlinePlayer();
        this.configureModel(model);
        return model;
    }

    @Override
    public void configureModel(OnlineObject obj) {
        OnlinePlayer model = (OnlinePlayer) obj;
        model.setCommandType(1);
        model.setId(getId());
        model.setRoomId(getRoom());
        model.setIp(getIp());
        model.setPort(getPort());
        model.setLocation(getLocation());
        model.setRotation(getRotation());
    }
}
