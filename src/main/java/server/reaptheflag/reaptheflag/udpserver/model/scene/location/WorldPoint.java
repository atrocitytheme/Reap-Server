package server.reaptheflag.reaptheflag.udpserver.model.scene.location;
import com.google.gson.annotations.Expose;

import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;

public class WorldPoint extends Point3d {
    public WorldPoint(double x, double y, double z) {
        super(x, y, z);
    }

    public WorldPoint(double[] p) {
        super(p);
    }

    public WorldPoint(Point3d p1) {
        super(p1);
    }

    public WorldPoint(Point3f p1) {
        super(p1);
    }

    public WorldPoint(Tuple3f t1) {
        super(t1);
    }

    public WorldPoint(Tuple3d t1) {
        super(t1);
    }

    public WorldPoint() {
    }
}
