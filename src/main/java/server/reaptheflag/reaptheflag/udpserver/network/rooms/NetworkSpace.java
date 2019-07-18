package server.reaptheflag.reaptheflag.udpserver.network.rooms;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkSpace {
    private AtomicInteger roomNum = new AtomicInteger(0);
    private ConcurrentHashMap<Integer, NetworkRoom> rooms = new ConcurrentHashMap<>();

    public void allocateRoom() {
        NetworkRoom room = new NetworkRoom();
        addRoom(room);
    }

    private void addRoom(NetworkRoom room) {
        rooms.put(roomNum.getAndIncrement(), room);
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
}
