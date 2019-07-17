package server.reaptheflag.reaptheflag.udpserver.network.receivable;
/**
 * data packet for udp
 * */
import com.google.gson.JsonSyntaxException;
import io.netty.channel.socket.DatagramPacket;
import server.reaptheflag.reaptheflag.udpserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.udpserver.network.receivable.parser.JsonFormatParser;
import server.reaptheflag.reaptheflag.udpserver.util.DataWrapper;
/**
 * mainly used for parse specific PlayerDataPacket from the client LiteNetLib
 * */
public final class PlayerDataPacket {
    private static int offset = 15;
    private DatagramPacket rawData;
    private JsonFormatParser<OnlinePlayer> parser;
    private boolean formatValid = true;
    private PlayerDataPacket(DatagramPacket packet) {
        this.rawData = packet;
    }
    public static PlayerDataPacket wrap(DatagramPacket packet) {
        return new PlayerDataPacket(packet);
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
}
