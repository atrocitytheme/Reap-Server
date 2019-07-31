package server.reaptheflag.reaptheflag.gameserver.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.game.tpyes.RoomType;
import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.model.logic.KeyFrame;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.TcpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.UdpClientUser;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// invariant: udp, tcp should always be synced
public class NetworkRoom {
    private static Logger LOGGER = LogManager.getLogger(NetworkRoom.class);
    protected Set<NetworkUser> basicPool = Collections.synchronizedSet(new HashSet<>());
    protected ConcurrentHashMap<NetworkUser, OnlineObject> udpData = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<NetworkUser, OnlineObject> tcpData = new ConcurrentHashMap<>();
    /**
     * updateUdpInfo the status of a specific client
     * */
    public void updateData(NetworkUser newClient) {

    }
    // updateUdpInfo the status in the room
    public void updateUdpInfo(NetworkUser user, OnlineObject model) {
        udpData.remove(user);
        udpData.put(user, model);
    }

    public void updateTcpInfo(NetworkUser user, OnlineObject model) {
        tcpData.remove(user);
        if (!tcpConnected(user)) {
            LOGGER.info("player " + user + " is removed from this room: " + user.getRoom());
            // if connection broken for some reason
            udpData.remove(user);
            basicPool.remove(user);
        } else {
            tcpData.put(user, model);
        }
    }

    public void exitPlayer(NetworkUser user) {
        disconnect(user);
        basicPool.remove(user);
    }

    public void clearSceneData(NetworkUser user) {
        tcpData.remove(user);
        udpData.remove(user);
    }

    public void disconnect(NetworkUser user) {
        for (NetworkUser u:getAllUdpUsers()) {
            if (u.equals(user)) {
                u.disconnect();
                break;
            }
        }
        for (NetworkUser u: getAllTcpUsers()) {
            if (u.equals(user)) {
                u.disconnect();
                break;
            }
        }
        udpData.remove(user);
        tcpData.remove(user);
    }

    public Collection<? extends OnlineObject> getAllUdpObjects() {
        return udpData.values();
    }

    public Collection<? extends OnlineObject> getAllTcpObjects() {
        return tcpData.values();
    }

    public Set<NetworkUser> getAllUdpUsers() {
        return udpData.keySet();
    }

    public Set<NetworkUser> getAllTcpUsers() {
        return tcpData.keySet();
    }

    @Deprecated
    public boolean contains(NetworkUser user) {
        return basicPool.contains(user);
    }

    public void addUdpInfo(NetworkUser user, OnlineObject model) {
        LOGGER.info("player : " + user + " has been spawned!");
        updateUdpInfo(user, model);
    }

    public OnlineObject getUdpObjectById(String id) {
        Optional<NetworkUser> user =  udpData.keySet().stream().filter((d)-> d.getId().equals(id)).findFirst();

        if (!user.isPresent()) return null;

        return udpData.get(user.get());
    }

    public int totalPlayer() {
        return basicPool.size();
    }

    public void addTcpInfo(NetworkUser user, OnlineObject model) {
        updateTcpInfo(user, model);
    }

    public void joinPlayer(NetworkUser user) {
        basicPool.add(user);
    }
    // hceck if the id and password are all correct in this room
    public boolean exists(NetworkUser user) {
        for (NetworkUser u: basicPool) {
            if (user.equals(u)) {
                return u.getPassword().equals(user.getPassword());
            }
        }

        return false;
    }

    protected boolean tcpConnected(NetworkUser user) {

        TcpClientUser tcp = (TcpClientUser) user;

        return tcp.getNetworkCondition().channel().isOpen();
    }

    public void finishGame() {
        LOGGER.info("game finished!");
    }
    // broadcast to all other users except user
    public void writeFrameToAllExcept(NetworkUser user, KeyFrame obj) {
    }

    public RoomType roomType() {
        return RoomType.VOID;
    }
}
