package server.reaptheflag.reaptheflag.gameserver.network.sendable;

import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.converter.JsonFormatConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Packet that's sent to the address, including: packet types, ip, data body
 * */
public class SentDataPacket extends SendableData {
    private List<OnlineObject> dataCollection = new ArrayList<>();
    public <T extends OnlineObject> void append(T onelineModel) {
        dataCollection.add(onelineModel);
    }
    public <T extends OnlineObject> SentDataPacket(Collection<T> models) {
        models.forEach((d) -> {
            append(d);
        });
    }
    public <T extends OnlineObject> SentDataPacket(T model) {
        append(model);
    }
    @Override
    public String deserilize() {
        return new JsonFormatConverter(dataCollection).convertToSendable();
    }

    @Override
    public byte[] getBytes() {
        return deserilize().getBytes();
    }
}
