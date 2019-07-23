package server.reaptheflag.reaptheflag.gameserver.validator.impl;

import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.validator.Checkable;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.gameserver.validator.UdpTokenValidator;
import server.reaptheflag.reaptheflag.gameserver.network.receivable.ReceivableUdpDataPacket;

/**
 * TODO: Finish the verification token procedure
 * */

@Component
public class UdpUdpTokenChecker implements UdpTokenValidator, Checkable {

    @Override
    public boolean isValidData(UdpClientUser udpClientUser) {
        boolean isFormatCorrect = checkFormat(udpClientUser);
        return isFormatCorrect;
    }

    private boolean checkFormat(UdpClientUser udpClient) {
        ReceivableUdpDataPacket packet = udpClient.getNetworkPacket();
        return packet.isFormatValid();
    }

    @Override
    public boolean generalCheck(NetworkUser user) {
        UdpClientUser udp = (UdpClientUser) user;
        return isValidData(udp);
    }
}