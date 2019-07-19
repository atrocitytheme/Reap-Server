package server.reaptheflag.reaptheflag.udpserver.network.manager;

import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;

@Service
public class TimeoutManager {
    public void manageTimeout(NetworkUser user) {
        user.decrementTimeout();
    }
}
