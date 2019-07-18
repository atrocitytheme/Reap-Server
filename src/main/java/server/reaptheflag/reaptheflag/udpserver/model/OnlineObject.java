package server.reaptheflag.reaptheflag.udpserver.model;

import server.reaptheflag.reaptheflag.udpserver.model.scene.location.Location;
import server.reaptheflag.reaptheflag.udpserver.model.scene.rotation.Rotation;

public class OnlineObject {
    String ip;
    int id;
    private int commandType;
    Location location;
    Rotation rotation;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommandType() {
        return commandType;
    }

    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }

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
