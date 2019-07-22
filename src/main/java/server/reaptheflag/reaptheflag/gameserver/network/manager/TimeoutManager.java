package server.reaptheflag.reaptheflag.gameserver.network.manager;

import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

@Service
public class TimeoutManager {
    public void manageTimeout(NetworkUser user) {
        user.decrementTimeout();
    }
}
