package server.reaptheflag.reaptheflag.udpserver.network.rooms;

import server.reaptheflag.reaptheflag.udpserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NetworkRoom {

    private ConcurrentHashMap<NetworkUser, ? extends OnlineObject> data = new ConcurrentHashMap<>();
    /**
     * update the status of a specific client
     * */
    public void updateData(NetworkUser newClient) {

    }
    // update the status in the room
    public void update() {

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
}
