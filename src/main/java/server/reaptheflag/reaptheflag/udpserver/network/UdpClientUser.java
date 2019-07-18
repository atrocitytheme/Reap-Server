package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.network.receivable.ReceivableUdpDataPacket;

/**
 * UdpClientUser is the alias for the online player connection
 * */
public class UdpClientUser extends NetworkUser{
    private ReceivableUdpDataPacket packet;
    public UdpClientUser(ReceivableUdpDataPacket packet) {
        this.packet = packet;
        setTimeout(CONNECTION_MAX_TIMEOUT);
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
    public int getPort() {
        int port = packet.content().getIntByName("Port");
        return port == 0 ? 5000 : port;
    }
    @Override
    public int getRoom() {
        return packet.content().getIntByName("RoomId");
    }
    @Override
    public String getName() {
        return packet.content().getAttributeByName("Name");
    }
    public ReceivableUdpDataPacket getNetworkPacket() {
        return packet;
    }
}
