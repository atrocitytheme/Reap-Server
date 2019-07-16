package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.network.receivable.DataPacket;

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
        return String.format("the client command type is: %d \n" +
                                "the client ip is: %s\n", commandType(), getIp());
    }
    /**
     * TODO: broadcast to all users
     * */
    @Override
    public void broadcast() {

    }
}
