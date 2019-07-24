package server.reaptheflag.reaptheflag.gameserver.model.scene.location;

import server.reaptheflag.reaptheflag.gameserver.model.scene.WorldPoint;

import java.io.Serializable;

public class Location implements Serializable {

    WorldPoint location;
    public Location () {}

    public Location (WorldPoint location) {
        this.location = location;
    }

    public WorldPoint getLocation() {
        return location;
    }

    public void setLocation(WorldPoint location) {
        this.location = location;
    }
}
