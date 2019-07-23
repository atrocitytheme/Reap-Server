package server.reaptheflag.reaptheflag.gameserver.validator;

import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public interface Checkable {
    boolean generalCheck(NetworkUser user);
}
