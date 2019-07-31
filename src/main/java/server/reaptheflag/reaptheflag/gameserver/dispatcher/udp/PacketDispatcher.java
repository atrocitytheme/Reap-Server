package server.reaptheflag.reaptheflag.gameserver.dispatcher.udp;
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
import server.reaptheflag.reaptheflag.gameserver.dispatcher.ProtocalDetectable;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.ProtocalType;
import server.reaptheflag.reaptheflag.gameserver.validator.impl.UdpUdpTokenChecker;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.Dispatchable;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.ReceivableUdpDataPacket;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

@Service
public final class PacketDispatcher extends SimpleChannelInboundHandler<DatagramPacket> implements ProtocalDetectable {

    private static final Logger LOGGER = LogManager.getLogger();
    private Dispatchable dispatcher;
    private UdpUdpTokenChecker udpTokenChecker;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {

        ReceivableUdpDataPacket packet = ReceivableUdpDataPacket.wrap(datagramPacket);
        String data = packet.readString();
        UdpClientUser udpClientUser = new UdpClientUser(packet);
        if (!udpTokenChecker.generalCheck(udpClientUser)) {
            LOGGER.info("ip: " + udpClientUser.getNetworkPacket().senderInfo() + " is trying to send invalid data");
            return;
        }
        udpClientUser.setTimeout(1000);
        dispatcher.dispatch(this, udpClientUser);
    }

    @Autowired
    @Qualifier(value = "commandDispatcher")
    public void setDispatcher(Dispatchable dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Autowired
    public void setValidator(UdpUdpTokenChecker validator) {
        this.udpTokenChecker = validator;
    }

    @Override
    public ProtocalType protocal() {
        return ProtocalType.UDP;
    }
}
