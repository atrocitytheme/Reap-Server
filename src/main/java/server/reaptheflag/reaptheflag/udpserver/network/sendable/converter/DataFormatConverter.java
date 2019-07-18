package server.reaptheflag.reaptheflag.udpserver.network.sendable.converter;

public abstract class DataFormatConverter<T>{
    T data;
    public abstract T convertToSendable();
}
