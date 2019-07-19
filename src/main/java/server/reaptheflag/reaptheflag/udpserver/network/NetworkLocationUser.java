package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.udpserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.udpserver.model.scene.location.Location;
import server.reaptheflag.reaptheflag.udpserver.model.scene.rotation.Rotation;
import server.reaptheflag.reaptheflag.udpserver.network.receivable.ReceivableUdpDataPacket;

public class NetworkLocationUser extends UdpClientUser implements Configurable{
    public NetworkLocationUser(ReceivableUdpDataPacket packet) {
        super(packet);
    }

    public NetworkLocationUser(UdpClientUser user) {
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
        model.setCommandType(commandType());
        model.setId(getId());
        model.setLocation(new Location());
        model.setRotation(new Rotation());
    }
}
