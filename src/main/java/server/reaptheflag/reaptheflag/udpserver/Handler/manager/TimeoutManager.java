package server.reaptheflag.reaptheflag.udpserver.Handler.manager;

import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

@Service
public class TimeoutManager {
    public void manageTimeout(NetworkUser user) {
        user.decrementTimeout();
    }
}
