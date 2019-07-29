package server.reaptheflag.reaptheflag.gameserver.validator.impl;

import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.TcpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.ReceivableTcpDataPacket;
import server.reaptheflag.reaptheflag.gameserver.validator.Checkable;

@Component
public class TcpTokenChecker implements Checkable {
    @Override
    public boolean generalCheck(NetworkUser user) {
        TcpClientUser tcpUser = (TcpClientUser) user;
        ReceivableTcpDataPacket tcpPacket = tcpUser.getNetworkPacket();
        return tcpPacket.isFormatValid();
    }
}
