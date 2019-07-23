package server.reaptheflag.reaptheflag.gameserver.validator;

import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;

/**
 * This module is mainly used for token validation procedure, it parses the encoding value of the client,
 * check if the client meets the requirement or if the data is valid.
 * */
public interface UdpTokenValidator {
    boolean isValidData(UdpClientUser udpClientUser);
}
