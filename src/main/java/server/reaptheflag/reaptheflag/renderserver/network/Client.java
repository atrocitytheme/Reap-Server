package server.reaptheflag.reaptheflag.renderserver.network;

import server.reaptheflag.reaptheflag.renderserver.network.receivable.DataPacket;

public class Client implements NetworkUser{
    private DataPacket packet;
    public Client(DataPacket packet) {
        this.packet = packet;
    }
    @Override
    public int commandType() {
        return packet.getCommandType();
    }
    @Override
    public String getIp() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("");
    }

    @Override
    public void broadcast() {

    }
}
