package server.reaptheflag.reaptheflag.gameserver.dispatcher.tcp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.udp.UdpCommandDispatchHelper;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

@Component
public class TcpCommandDispatcherHelper {
    private static Logger LOGGER = LogManager.getLogger(UdpCommandDispatchHelper.class);
    public Command taleCommand(NetworkUser user, NetworkSpace space) {
        return null;
    }
}
