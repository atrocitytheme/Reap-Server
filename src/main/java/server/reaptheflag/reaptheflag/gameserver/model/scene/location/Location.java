package server.reaptheflag.reaptheflag.gameserver.model.scene.location;

public class Location {

    WorldPoint location = new WorldPoint(.0, .0, .0);
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
