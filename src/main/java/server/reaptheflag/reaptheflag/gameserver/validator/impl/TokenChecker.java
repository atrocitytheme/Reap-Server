package server.reaptheflag.reaptheflag.gameserver.validator.impl;

import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;
import server.reaptheflag.reaptheflag.gameserver.validator.TokenValidator;
/**
 * TODO: Finish the verification token procedure
 * */

@Component
public class TokenChecker extends TokenValidator {
    @Override
    public boolean isValidData(UdpClientUser udpClientUser) {
        boolean isFormatCorrect = super.isValidData(udpClientUser);

        if (isFormatCorrect) {
            LOGGER.info("IP: " + udpClientUser.getIp() + " is trying to send data without correct tokens" );
        }

        return isFormatCorrect;
    }
}