package server.reaptheflag.reaptheflag.gameserver.network.receivable;

import com.google.gson.JsonSyntaxException;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.parser.JsonFormatParser;

public class ReceivableTcpDataPacket extends ReceivableDataPacket{
    private String rawData;
    private boolean dataValid  = true;
    private JsonFormatParser<OnlinePlayer> parser;
    public ReceivableTcpDataPacket(String data) {
        this.rawData = data;
        try {
            this.parser = new JsonFormatParser<>(rawData.trim(), OnlinePlayer.class);
        } catch (JsonSyntaxException e) {
            dataValid = false;
        }
    }

    public JsonFormatParser content() {
        return this.parser;
    }

    @Override
    public String readString() {
        return rawData;
    }

    @Override
    public int getLength() {
        return rawData.length();
    }

    @Override
    public boolean isFormatValid() {
        return dataValid;
    }
}
