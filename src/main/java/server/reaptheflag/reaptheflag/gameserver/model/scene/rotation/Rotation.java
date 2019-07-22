package server.reaptheflag.reaptheflag.gameserver.model.scene.rotation;

import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;

public class Rotation extends Point3d {
    public Rotation(double x, double y, double z) {
        super(x, y, z);
    }

    public Rotation(double[] p) {
        super(p);
    }

    public Rotation(Point3d p1) {
        super(p1);
    }

    public Rotation(Point3f p1) {
        super(p1);
    }

    public Rotation(Tuple3f t1) {
        super(t1);
    }

    public Rotation(Tuple3d t1) {
        super(t1);
    }

    public Rotation() {
    }
}
