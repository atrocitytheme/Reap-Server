package server.reaptheflag.reaptheflag.renderserver.configuration;
/***
 * bootstrap event handler
 * components: eventTrigger layer, dispatcher layer, eventhandler lauyer, validation layer
 */
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;


public class PacketHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        final ByteBuf buf = Unpooled.wrappedBuffer(datagramPacket.content());
        final int length = buf.readableBytes();
        final byte[] receiveBuf = new byte[length];
        buf.readBytes(receiveBuf);
    }
}
