package server.reaptheflag.reaptheflag.gameserver.dispatcher.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.ProtocalDetectable;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.ProtocalType;

@Service
public final class StreamDispatcher extends SimpleChannelInboundHandler<String> implements ProtocalDetectable {

    private static Logger LOGGER = LogManager.getLogger(StreamDispatcher.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) {
        LOGGER.info("tcp connection received");
    }

    @Override
    public ProtocalType protocal() {
        return ProtocalType.TCP;
    }
}
