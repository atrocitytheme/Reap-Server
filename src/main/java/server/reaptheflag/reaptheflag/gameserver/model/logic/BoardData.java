package server.reaptheflag.reaptheflag.gameserver.model.logic;


import java.util.Map;

public class BoardData extends KeyFrame{

    public Map<String, Integer> getRoomData() {
        return roomData;
    }

    public void setRoomData(Map<String, Integer> roomData) {
        this.roomData = roomData;
    }

    Map<String, Integer> roomData;
}
