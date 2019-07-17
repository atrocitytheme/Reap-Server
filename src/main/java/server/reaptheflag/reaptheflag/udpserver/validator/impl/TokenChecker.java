package server.reaptheflag.reaptheflag.udpserver.validator.impl;

import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.udpserver.network.UdpClient;
import server.reaptheflag.reaptheflag.udpserver.validator.TokenValidator;
/**
 * TODO: Finish the verification token procedure
 * */

@Component
public class TokenChecker extends TokenValidator {
    @Override
    public boolean isValidData(UdpClient udpClient) {
        boolean isFormatCorrect = super.isValidData(udpClient);

        if (isFormatCorrect) {
            LOGGER.info("IP: " + udpClient.getIp() + " is trying to send data without correct tokens" );
        }

        return isFormatCorrect;
    }
}