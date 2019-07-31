package server.reaptheflag.reaptheflag.gameserver.network.sendable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.converter.JsonFormatConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class SafePacketSentData extends SendableData {
    private List<OnlineObject> dataCollection = new ArrayList<>();
    private static Logger LOGGER = LogManager.getLogger(SafePacketSentData.class);
    public <T extends OnlineObject> SafePacketSentData(Collection<T> models) {
        models.forEach((d) -> {
            safeAppend(d);
        });
    }
    public <T extends OnlineObject>void safeAppend(T model) {
        try {
            dataCollection.add((OnlineObject) (model.clone()));
        } catch (CloneNotSupportedException e) {
            LOGGER.error(e);
        }
    }

    public OnlineObject get(NetworkUser user) {
        Optional<OnlineObject> obj = dataCollection.stream().filter((d) -> {
            return d.getIp().equals(user.getIp()) && d.getPort() == user.getPort(); // TODO: change it to account id
        }).findFirst();

        return obj.isEmpty() ? null : obj.get();
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
