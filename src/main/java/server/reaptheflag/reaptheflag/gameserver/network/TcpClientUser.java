package server.reaptheflag.reaptheflag.gameserver.network;

import io.netty.channel.ChannelHandlerContext;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.ReceivableTcpDataPacket;

import java.net.InetSocketAddress;

public class TcpClientUser extends NetworkUser{
    protected ReceivableTcpDataPacket packet;
    protected ChannelHandlerContext networkCondition;
    public TcpClientUser(String data, ChannelHandlerContext ctx) {
        this.packet = new ReceivableTcpDataPacket(data);
        this.networkCondition = ctx;
    }

    public ReceivableTcpDataPacket getNetworkPacket() {
        return packet;
    }

    public ChannelHandlerContext getNetworkCondition() {
        return networkCondition;
    }

    @Override
    public int commandType() {
        return this.packet.content().getIntByName("CommandType");
    }

    @Override
    public String getIp() {
        return networkCondition.channel().remoteAddress().toString();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public int getRoom() {
        return packet.content().getIntByName("RoomId");
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public String getId() {
        return this.packet.content().getAttributeByName("Id");
    }

    @Override
    public InetSocketAddress rawAddress() {
        return (InetSocketAddress) getNetworkCondition().channel().remoteAddress();
    }

    @Override
    public String getPassword() {
        return this.packet.content().getAttributeByName("Password");
    }

    @Override
    public void disconnect() {
        this.networkCondition.close();
    }

    @Override
    public boolean isSpawned() {
        return super.isSpawned();
    }

    @Override
    public void setSpawned(boolean spawned) {
        super.setSpawned(spawned);
    }

    public String getEventTrigger() {
        return this.packet.content().getAttributeByName("EventTrigger");
    }
}
