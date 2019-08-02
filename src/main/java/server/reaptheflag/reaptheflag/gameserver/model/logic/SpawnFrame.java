package server.reaptheflag.reaptheflag.gameserver.model.logic;

import server.reaptheflag.reaptheflag.gameserver.model.scene.location.Location;
import server.reaptheflag.reaptheflag.gameserver.model.scene.rotation.Rotation;

public class SpawnFrame extends KeyFrame{
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    int roomId;

    Location location = new Location();

    Rotation rotation = new Rotation();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }
}
