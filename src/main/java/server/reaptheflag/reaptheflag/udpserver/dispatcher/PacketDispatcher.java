package server.reaptheflag.reaptheflag.udpserver.dispatcher;
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
import server.reaptheflag.reaptheflag.udpserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.udpserver.network.receivable.ReceivableUdpDataPacket;
import server.reaptheflag.reaptheflag.udpserver.validator.TokenValidator;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

@Service
public final class PacketDispatcher extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger LOGGER = LogManager.getLogger();
    private Dispatchable dispatcher;
    private TokenValidator validator;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {

        ReceivableUdpDataPacket packet = ReceivableUdpDataPacket.wrap(datagramPacket);
        String data = packet.readString();
        LOGGER.info("the current received data is:" + data + "\nat: " + DateToolUtil.logCurrentDate());
        LOGGER.info("the length of the data is: " + packet.getLength() + "bytes");
        LOGGER.info("the length of json is: " + data.length());
        packet.loadContent();
        UdpClientUser udpClientUser = new UdpClientUser(packet);
        if (!validator.isValidData(udpClientUser)) {
            LOGGER.info("user: " + udpClientUser.getName() + " is trying to send invalid data ::: intercepted");
            return;
        }
        dispatcher.dispatch(this, udpClientUser);
    }

    @Autowired
    @Qualifier(value = "commandDispatcher")
    public void setDispatcher(Dispatchable dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Autowired
    public void setValidator(TokenValidator validator) {
        this.validator = validator;
    }
}
