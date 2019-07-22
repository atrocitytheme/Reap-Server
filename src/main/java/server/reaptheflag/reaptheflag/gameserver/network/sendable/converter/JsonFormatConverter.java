package server.reaptheflag.reaptheflag.gameserver.network.sendable.converter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFormatConverter extends DataFormatConverter<String> {
    private static Gson gson = new GsonBuilder().serializeNulls().
            setPrettyPrinting().
            setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create();
    public <T> JsonFormatConverter(T data) {
        this.data = gson.toJson(data);
    }

    @Override
    public String convertToSendable() {
        return data;
    }
}
