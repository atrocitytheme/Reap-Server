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
                        ChannelPipeline pipe = nioDatagramChannel.pipeline();
                        pipe.addLast(new PacketHandler());
                    }
                });

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("udp server initialized!" + address);
        programBootStrap.bind(address, port).sync().channel().closeFuture().await();
        System.out.println("passed!");
    }
}
