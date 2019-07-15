package server.reaptheflag.reaptheflag.renderserver;
/**
 * server initialization, use SO_BROADCAST udp channel
 * */
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.DatagramPacketDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import server.reaptheflag.reaptheflag.renderserver.configuration.PacketHandler;

import java.net.InetAddress;

public class UdpServer {
    private int port;
    public UdpServer(int port) {
        this.port = port;
    }
    public void run() throws Exception {
        final NioEventLoopGroup group = new NioEventLoopGroup();
        final Bootstrap programBootStrap = new Bootstrap();
        programBootStrap.group(group).
                channel(NioDatagramChannel.class).
                option(ChannelOption.SO_BROADCAST, true).
                handler(new ChannelInitializer<NioDatagramChannel>() {

                    @Override
                    protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
                        System.out.println("initialized!");
                        ChannelPipeline pipe = nioDatagramChannel.pipeline();
                        pipe.addLast(new PacketHandler());
                    }
                }); // packet handler is the bootstrap of the processing program

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("udp server initialized!" + address);
        programBootStrap.bind(address, port).sync().channel().closeFuture().await();
    }
}
