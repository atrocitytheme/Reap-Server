package server.reaptheflag.reaptheflag.gameserver.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.game.modes.normal.NormalRoom;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkSpace {
    private AtomicInteger roomNum = new AtomicInteger(0);
    private ConcurrentHashMap<Integer, NetworkRoom> rooms = new ConcurrentHashMap<>();
    private Logger LOGGER = LogManager.getLogger(NetworkSpace.class);
    public void allocateRoom(int roomType) {
        NetworkRoom room;
        if (roomType == 1) {
            room = new NormalRoom();
        } else {
            room = new NetworkRoom();
        }
        addRoom(room);
    }

    private void addRoom(NetworkRoom room) {
        rooms.put(roomNum.incrementAndGet(), room);
        room.assignId(roomNum.get());
        LOGGER.info("RoomId: " + (roomNum.get() - 1) + " created!");
    }

    public int getLatestRoomId() {
        return roomNum.get();
    }

    public int totalRooms() {
        return roomNum.get();
    }

    public List<NetworkRoom> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    public NetworkRoom getRoom(int id) {
        return rooms.get(id);
    }

    public NetworkRoom getRoom(NetworkUser user) {
        return getRoom(user.getRoom());
    }

    public void disconnect(NetworkUser user) {
        rooms.get(user.getRoom()).disconnect(user);
    }

    private void removeRoom(int roomId) {
        rooms.remove(roomId);
        if (roomId == getLatestRoomId()) {
            roomNum.incrementAndGet();
        }
    }

    public void removeRoom(NetworkRoom room) {
        removeRoom(room.getRoomId());
    }
}
