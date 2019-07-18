package server.reaptheflag.reaptheflag.udpserver.network.sendable.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import server.reaptheflag.reaptheflag.udpserver.model.OnlineObject;

public class JsonFormatConverter extends DataFormatConverter<String> {
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    public <T> JsonFormatConverter(T data) {
        this.data = gson.toJson(data);
    }

    @Override
    public String convertToSendable() {
        return data;
    }
}
