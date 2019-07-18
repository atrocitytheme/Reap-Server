package server.reaptheflag.reaptheflag.udpserver;
/**
 * server initialization, use SO_BROADCAST udp channel
 * */
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import server.reaptheflag.reaptheflag.udpserver.dispatcher.PacketHandler;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

import java.net.InetAddress;

public class UdpServer {
    private static Logger LOGGER = LogManager.getLogger(UdpServer.class);
    private int port;
    @Autowired
    private PacketHandler handler;
    @Autowired
    private NetworkSpace space1; // the network space of the room
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
                        space1.allocateRoom();
                        ChannelPipeline pipe = nioDatagramChannel.pipeline();
                        pipe.addLast("decoder", new ByteArrayDecoder());
                        pipe.addLast("encoder", new ByteArrayEncoder());
                        pipe.addLast("clientHandler", handler);
                    }
                }); // packet handler is the bootstrap of the processing program

        InetAddress address = InetAddress.getLocalHost();
        LOGGER.info("udp server initialized!" + address);
        programBootStrap.bind(address, port).sync().channel().closeFuture().await();
    }
}
