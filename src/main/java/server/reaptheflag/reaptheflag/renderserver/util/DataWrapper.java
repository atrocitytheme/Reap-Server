package server.reaptheflag.reaptheflag.renderserver.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.socket.DatagramPacket;

import java.nio.charset.StandardCharsets;
/**
 * wrap the buf with bigedaian style
 * */
public class DataWrapper {
    private ByteBuf data;
    private int offset = 0;

    private DataWrapper(ByteBuf buf) {
        this.data = buf;
    }
    public static DataWrapper wrap(DatagramPacket data) {
        ByteBuf source = data.copy().content();
        final ByteBuf buf = Unpooled.wrappedBuffer(source);
        return new DataWrapper(buf);
    }

    public DataWrapper setReadableOffset(int offset) {

        this.offset = offset;

        return this;
    }

    public byte[] getBytes() {
        byte[] src = new byte[data.readableBytes()];
        data.readBytes(src);
        return src;
    }

    public String convertToString() {
        return convertToString(getBytes(), offset);
    }

    /**
     * convert the current data to string
     * */
    public String convertToString(byte[] array, int offset) {
        if (array.length > offset) {
            byte[] dst = new byte[array.length - offset];
            System.arraycopy(array, offset, dst, 0, array.length - offset);
            return new String(dst, StandardCharsets.UTF_8);
        }

        return new String(array, StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        return String.format("");
    }
}
