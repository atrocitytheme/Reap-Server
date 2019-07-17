package server.reaptheflag.reaptheflag.udpserver.model;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class World {
    private static Set<OnlinePlayer> playres = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public World() {
    }

    public void update() {
    }
}
