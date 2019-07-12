package server.reaptheflag.reaptheflag.renderserver.configuration;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class PacketHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        final InetAddress addr = datagramPacket.getAddress();
        final ByteBuf buf = Unpooled.wrappedBuffer(datagramPacket.getData());
        final int length = buf.readableBytes();
        final byte[] receiveBuf = new byte[length];
        buf.readBytes(receiveBuf);
        System.out.println("Systen handling...");
    }
}
