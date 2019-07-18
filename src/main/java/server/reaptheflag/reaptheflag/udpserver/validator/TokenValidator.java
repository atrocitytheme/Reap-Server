package server.reaptheflag.reaptheflag.udpserver.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.udpserver.network.UdpClient;
import server.reaptheflag.reaptheflag.udpserver.network.receivable.ReceivableUdpDataPacket;

/**
 * This module is mainly used for token validation procedure, it parses the encoding value of the client,
 * check if the client meets the requirement or if the data is valid.
 * */
public abstract class TokenValidator {
    protected static Logger LOGGER = LogManager.getLogger();
    public boolean isValidData(UdpClient udpClient) {
        ReceivableUdpDataPacket packet = udpClient.getNetworkPacket();
        boolean res = packet.isFormatValid();
        if (!res) LOGGER.info("invalid format reveived in udp server");
        return res;
    }
}
