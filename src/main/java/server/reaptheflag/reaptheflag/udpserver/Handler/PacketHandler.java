package server.reaptheflag.reaptheflag.udpserver.Handler;
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
import server.reaptheflag.reaptheflag.udpserver.dispatcher.Dispatchable;
import server.reaptheflag.reaptheflag.udpserver.network.Client;
import server.reaptheflag.reaptheflag.udpserver.network.receivable.DataPacket;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

@Service("basicPacketHandler")
public final class PacketHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger LOGGER = LogManager.getLogger();
    private Dispatchable dispatcher;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {

        DataPacket packet = DataPacket.wrap(datagramPacket);
        String data = packet.readString();
        LOGGER.info("the current received data is: " + data + "\nat: " + DateToolUtil.logCurrentDate());
        LOGGER.info("the length of the data is: " + packet.getLength() + "bytes");
        dispatcher.dispatch(this, new Client(packet));
    }

    @Autowired
    @Qualifier(value = "commandDispatcher")
    public void setDispatcher(Dispatchable dispatcher) {
        this.dispatcher = dispatcher;
    }
}
