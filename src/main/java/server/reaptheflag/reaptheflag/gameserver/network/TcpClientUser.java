package server.reaptheflag.reaptheflag.gameserver.network;

import server.reaptheflag.reaptheflag.gameserver.network.receivable.ReceivableTcpDataPacket;

import java.net.InetSocketAddress;

public class TcpClientUser extends NetworkUser{
    protected ReceivableTcpDataPacket packet;
    public TcpClientUser(String data) {
        this.packet = new ReceivableTcpDataPacket(data);
    }

    @Override
    public int commandType() {
        return 0;
    }

    @Override
    public String getIp() {
        return null;
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
        return 0;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public InetSocketAddress rawAddress() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public boolean isSpawned() {
        return super.isSpawned();
    }

    @Override
    public void setSpawned(boolean spawned) {
        super.setSpawned(spawned);
    }
}
