package server.reaptheflag.reaptheflag.gameserver.dispatcher;
/**
 * This is the dispatcher for different types of commands, it'll use differnet command to solve the request
 * TODO: add dispatcher of differenct commands
 * */
import org.springframework.beans.factory.annotation.Autowired;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.tcp.TcpCommandDispatcherHelper;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.udp.UdpCommandDispatchHelper;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;

public class CommandEventDispatcher implements Dispatchable{

    private NetworkSpace space1;

    private UdpCommandDispatchHelper udpHelper;

    private TcpCommandDispatcherHelper tcpHelper;
    public void dispatch(ProtocalDetectable handler, NetworkUser client) {
        if (handler.protocal() == ProtocalType.UDP) {
            Command command = udpHelper.takeCommand(client, space1);
            command.execute(client, space1);
        } else if (handler.protocal() == ProtocalType.TCP) {
            Command command = tcpHelper.taleCommand(client, space1);
            command.execute(client, space1);
        } // other protocals
    }

    @Autowired
    public void setSpace1(NetworkSpace space1) {
        this.space1 = space1;
    }

    @Autowired
    public void setTcpHelper(TcpCommandDispatcherHelper tcpHelper) {
        this.tcpHelper = tcpHelper;
    }

    @Autowired
    public void setUdpHelper(UdpCommandDispatchHelper udpHelper) {
        this.udpHelper = udpHelper;
    }
}
