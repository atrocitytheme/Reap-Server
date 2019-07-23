package server.reaptheflag.reaptheflag.gameserver.network.receivable;

public abstract class ReceivableDataPacket {
    public abstract String readString();
    public abstract int getLength();
    public abstract boolean isFormatValid();
}
