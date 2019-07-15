package server.reaptheflag.reaptheflag.renderserver.Handler;
/***
 * bootstrap event handler
 * components: eventTrigger layer, dispatcher layer, eventhandler lauyer, validation layer
 */
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.renderserver.dispatcher.CommandEventDispatcher;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

import java.nio.charset.StandardCharsets;

@Service("basicPacketHandler")
public final class PacketHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger LOGGER = LogManager.getLogger();

    private CommandEventDispatcher dispatcher;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        dispatcher.handle(this, datagramPacket);
        final ByteBuf buf = Unpooled.wrappedBuffer(datagramPacket.content());
        final int length = buf.readableBytes();
        final byte[] receiveBuf = new byte[length];
        buf.readBytes(receiveBuf);
        LOGGER.info("connection recieved in " + DateToolUtil.logCurrentDate());
        System.out.println(convertToString(receiveBuf));
    }

    @Autowired
    @Qualifier(value = "commandDispatcher")
    public void setDispatcher(CommandEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    private String convertToString(byte[] array) {
        return new String(array, StandardCharsets.UTF_8);
    }
}
