package server.reaptheflag.reaptheflag.gameserver.network.sendable.converter;

public abstract class DataFormatConverter<T>{
    T data;
    public abstract T convertToSendable();
}
