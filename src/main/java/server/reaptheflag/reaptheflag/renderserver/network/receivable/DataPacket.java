package server.reaptheflag.reaptheflag.renderserver.network.receivable;
/**
 * data packet for udp
 * */
import io.netty.channel.socket.DatagramPacket;
import server.reaptheflag.reaptheflag.renderserver.util.DataWrapper;

public class DataPacket {
    private static int offset = 15;
    private DatagramPacket rawData;
    private DataPacket(DatagramPacket packet) {
        this.rawData = packet;
    }
    public static DataPacket wrap(DatagramPacket packet) {
        return new DataPacket(packet);
    }
    public String readString() {
        return DataWrapper.wrap(rawData).setReadableOffset(offset).convertToString();
    }
    /**
     * TODO: get the ip from the datapack
     * */
    public String getIp() {
        return "";
    }
    /**
     * get the passed token
     * */
    public String getToken() {
        return "";
    }

    public int getCommandType() {
        return 0;
    }

    public int getLength() {
        return DataWrapper.wrap(rawData).setReadableOffset(offset).length();
    }
}
