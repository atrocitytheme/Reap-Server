package server.reaptheflag.reaptheflag.gameserver.network.receivable;
/**
 * data packet for udp
 * */
import com.google.gson.JsonSyntaxException;
import io.netty.channel.socket.DatagramPacket;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.parser.JsonFormatParser;
import server.reaptheflag.reaptheflag.gameserver.util.DataWrapper;

import java.net.InetSocketAddress;

/**
 * mainly used for parse specific ReceivableUdpDataPacket from the client LiteNetLib
 * */
public final class ReceivableUdpDataPacket {
    private static int offset = 0;
    private DatagramPacket rawData;
    private JsonFormatParser<OnlinePlayer> parser;
    private boolean formatValid = true;
    private ReceivableUdpDataPacket(DatagramPacket packet) {
        this.rawData = packet;
    }
    public static ReceivableUdpDataPacket wrap(DatagramPacket packet) {
        return new ReceivableUdpDataPacket(packet);
    }
    public String readString() {
        return DataWrapper.wrap(rawData).setReadableOffset(offset).convertToString();
    }
    public JsonFormatParser<OnlinePlayer> content() {
        loadContent();
        return parser;
    }
    public int getLength() {
        return DataWrapper.wrap(rawData).setReadableOffset(offset).length();
    }
    public boolean isFormatValid() {
        return formatValid;
    }
    /**
     * load the string content to the parser
     * */
    public void loadContent() {
        if (parser == null) {
            try {
                parser = new JsonFormatParser<>(readString(), OnlinePlayer.class);
            } catch (JsonSyntaxException e) {
                formatValid = false;
            }
        }
    }

    public InetSocketAddress senderInfo() {
        return rawData.sender();
    }
}
