package server.reaptheflag.reaptheflag.gameserver.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import server.reaptheflag.reaptheflag.gameserver.network.rooms.NetworkSpace;

import java.net.InetAddress;

public class TcpServer implements Startable{

    private static Logger LOGGER = LogManager.getLogger(TcpServer.class);
    private int port;
    @Autowired
    private NetworkSpace space1; // the network space of the room
    @Autowired
    private NioEventLoopGroup worker1;
    @Autowired
    private NioEventLoopGroup boss;

    public TcpServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        final NioEventLoopGroup group = new NioEventLoopGroup();

        final ServerBootstrap programBootStrap = new ServerBootstrap();
        programBootStrap.group(boss, worker1).
                channel(NioServerSocketChannel.class).
                option(ChannelOption.SO_KEEPALIVE, true).handler(
                        new ChannelInitializer<Channel>() {
                            @Override
                            protected void initChannel(Channel socketChannel) {

                            }
                        }

                        ).
                childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel nioDatagramChannel) {

                        ChannelPipeline pipe = nioDatagramChannel.pipeline();
                        pipe.addLast("decoder", new ByteArrayDecoder());
                        pipe.addLast("encoder", new ByteArrayEncoder());
/*
                        pipe.addLast("clientHandler", handler);
*/
                    }
                }).childOption(ChannelOption.SO_KEEPALIVE, true); // packet handler is the bootstrap of the processing program

        InetAddress address = InetAddress.getLocalHost();
        LOGGER.info("tcp server initialized!" + address);
        programBootStrap.bind(address, port).sync().channel().closeFuture().await();
    }

    @Override
    public String getName() {
        return "tcp";
    }
}
