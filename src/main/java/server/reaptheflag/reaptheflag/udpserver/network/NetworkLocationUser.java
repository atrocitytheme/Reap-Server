package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.udpserver.network.receivable.ReceivableUdpDataPacket;

public class NetworkLocationUser extends UdpClientUser{
    public NetworkLocationUser(ReceivableUdpDataPacket packet) {
        super(packet);
    }

    public NetworkLocationUser(UdpClientUser user) {
        super(user.getNetworkPacket());
    }

    public OnlinePlayer generateModel() {
        OnlinePlayer model = new OnlinePlayer();
        return model;
    }
}
