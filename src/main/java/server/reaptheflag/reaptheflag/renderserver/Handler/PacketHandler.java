package server.reaptheflag.reaptheflag.renderserver.Handler;
/***
 * bootstrap event handler
 * components: eventTrigger layer, dispatcher layer, eventhandler lauyer, validation layer
 */
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.renderserver.dispatcher.Dispatchable;
import server.reaptheflag.reaptheflag.renderserver.network.Client;
import server.reaptheflag.reaptheflag.renderserver.network.receivable.DataPacket;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

@Service("basicPacketHandler")
public final class PacketHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger LOGGER = LogManager.getLogger();
    private Dispatchable dispatcher;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {
        DataPacket packet = DataPacket.wrap(datagramPacket);
        dispatcher.dispatch(this, new Client(packet));
        String data = packet.readString();
        LOGGER.info("the current received data is: " + data + "at: " + DateToolUtil.logCurrentDate());
    }

    @Autowired
    @Qualifier(value = "commandDispatcher")
    public void setDispatcher(Dispatchable dispatcher) {
        this.dispatcher = dispatcher;
    }
}
