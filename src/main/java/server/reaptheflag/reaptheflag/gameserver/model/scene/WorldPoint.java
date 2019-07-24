package server.reaptheflag.reaptheflag.gameserver.model.scene;

import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;
import java.io.Serializable;

public class WorldPoint implements Serializable {
    private float x;
    private float y;
    private float z;

    public WorldPoint() {}

    public WorldPoint(double x, double y, double z) {

        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
