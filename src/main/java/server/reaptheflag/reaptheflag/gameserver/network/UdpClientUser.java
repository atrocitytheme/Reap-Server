package server.reaptheflag.reaptheflag.gameserver.network;

import server.reaptheflag.reaptheflag.gameserver.network.receivable.ReceivableUdpDataPacket;

import java.net.InetSocketAddress;

/**
 * UdpClientUser is the alias for the online player connection
 * */
public class UdpClientUser extends NetworkUser{
    protected ReceivableUdpDataPacket packet;
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
        return packet.senderInfo().getAddress().getHostAddress();
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
        return packet.senderInfo().getPort();
    }

    @Override
    public String getId() {
        return this.packet.content().getAttributeByName("Id");
    }

    @Override
    public InetSocketAddress rawAddress() {
        return packet.senderInfo();
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
