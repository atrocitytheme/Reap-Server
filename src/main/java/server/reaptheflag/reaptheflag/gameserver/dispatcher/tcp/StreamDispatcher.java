package server.reaptheflag.reaptheflag.gameserver.dispatcher.tcp;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.CommandEventDispatcher;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.ProtocalDetectable;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.ProtocalType;
import server.reaptheflag.reaptheflag.gameserver.network.TcpClientUser;

@Service
@ChannelHandler.Sharable
public final class StreamDispatcher extends SimpleChannelInboundHandler<String> implements ProtocalDetectable {

    private static Logger LOGGER = LogManager.getLogger(StreamDispatcher.class);

    private CommandEventDispatcher dispatcher;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) {
        LOGGER.info("tcp connection received: " + channelHandlerContext.channel().remoteAddress());
        TcpClientUser tcpUser = new TcpClientUser(s);
        dispatcher.dispatch(this, tcpUser);
    }

    @Override
    public ProtocalType protocal() {
        return ProtocalType.TCP;
    }

    @Autowired
    public void setDispatcher(CommandEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
}
