package server.reaptheflag.reaptheflag.gameserver.model.scene.rotation;

import server.reaptheflag.reaptheflag.gameserver.model.scene.WorldPoint;

import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;
import java.io.Serializable;

public class Rotation extends WorldPoint implements Serializable {
    public Rotation() {}
    public Rotation(double x, double y, double z) {
        super(x, y, z);
    }
}
