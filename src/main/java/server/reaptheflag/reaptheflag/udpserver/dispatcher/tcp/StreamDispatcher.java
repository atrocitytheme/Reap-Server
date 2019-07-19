package server.reaptheflag.reaptheflag.udpserver.dispatcher.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public final class StreamDispatcher extends SimpleChannelInboundHandler<String> {

    private static Logger LOGGER = LogManager.getLogger(StreamDispatcher.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) {
        LOGGER.info("tcp connected!");
    }
}
