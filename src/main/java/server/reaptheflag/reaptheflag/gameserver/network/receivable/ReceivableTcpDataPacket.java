package server.reaptheflag.reaptheflag.gameserver.network.receivable;

public class ReceivableTcpDataPacket extends ReceivableDataPacket{

    @Override
    public String readString() {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isFormatValid() {
        return false;
    }
}
