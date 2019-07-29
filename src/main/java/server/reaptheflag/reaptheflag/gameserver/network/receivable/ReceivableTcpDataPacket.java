package server.reaptheflag.reaptheflag.gameserver.network.receivable;

public class ReceivableTcpDataPacket extends ReceivableDataPacket{
    private String rawData;

    public ReceivableTcpDataPacket(String data) {
        this.rawData = data;
    }

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
