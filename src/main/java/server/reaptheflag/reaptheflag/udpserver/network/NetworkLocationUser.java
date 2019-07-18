package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.udpserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.udpserver.network.receivable.ReceivableUdpDataPacket;

public class NetworkLocationUser extends UdpClientUser implements Configurable{
    public NetworkLocationUser(ReceivableUdpDataPacket packet) {
        super(packet);
    }

    public NetworkLocationUser(UdpClientUser user) {
        super(user.getNetworkPacket());
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
        model.setIp(getIp());
    }
}
