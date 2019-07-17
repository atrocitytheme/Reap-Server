package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.network.receivable.PlayerDataPacket;
import server.reaptheflag.reaptheflag.udpserver.network.sendable.SendableData;

/**
 * UdpClient is the alias for the online player connection
 * */
public class UdpClient implements NetworkUser{
    private PlayerDataPacket packet;
    public UdpClient(PlayerDataPacket packet) {
        this.packet = packet;
        packet.loadContent();
    }

    @Override
    public int commandType() {
        return packet.content().getIntByName("CommandType");
    }

    @Override
    public String getIp() {
        return packet.content().getAttributeByName("Ip");
    }

    @Override
    public String getToken() {
        return packet.content().getAttributeByName("Token");
    }

    @Override
    public String toString() {
        return String.format("the client command type is: %d \n" +
                                "the client ip is: %s\n", commandType(), getIp());
    }

    @Override
    public String getName() {
        return packet.content().getAttributeByName("Name");
    }
    /**
     * TODO: broadcast to this client
     * */
    @Override
    public void broadcast(SendableData data) {

    }

    public PlayerDataPacket getNetworkPacket() {
        return packet;
    }
}
