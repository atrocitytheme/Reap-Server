package server.reaptheflag.reaptheflag.udpserver.network.rooms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.udpserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NetworkRoom {
    private static Logger LOGGER = LogManager.getLogger(NetworkRoom.class);
    private ConcurrentHashMap<NetworkUser, OnlineObject> data = new ConcurrentHashMap<>();
    /**
     * update the status of a specific client
     * */
    public void updateData(NetworkUser newClient) {

    }
    // update the status in the room
    public void update(NetworkUser user, OnlineObject model) {
        data.put(user, model);
    }

    public void disconnect(NetworkUser user) {
        user.disconnect();
        data.remove(user);
    }

    public Collection<? extends OnlineObject> getAllObjects() {
        return data.values();
    }

    public Set<NetworkUser> getAllUsers() {
        return data.keySet();
    }

    public boolean contains(NetworkUser user) {
        return data.containsKey(user);
    }

    public void addPlayer(NetworkUser user, OnlineObject model) {
        LOGGER.info("player : " + user + " has been spawned!");
        update(user, model);
    }

    public OnlineObject get(NetworkUser user) {
        return data.get(user);
    }
}