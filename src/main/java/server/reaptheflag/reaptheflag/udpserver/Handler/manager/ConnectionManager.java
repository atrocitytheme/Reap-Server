package server.reaptheflag.reaptheflag.udpserver.Handler.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

@Service
public class ConnectionManager {
    private static Logger LOGGER = LogManager.getLogger(ConnectionManager.class);
    @Autowired
    public void setSpace(NetworkSpace space) {
        this.space = space;
    }

    private NetworkSpace space;

    public void manageConnection(NetworkUser user) {
        if (user.getTimeout() < 0) {
            LOGGER.info("user: " + user + " timed out!!");
            space.disconnect(user);
        }
    }
}
