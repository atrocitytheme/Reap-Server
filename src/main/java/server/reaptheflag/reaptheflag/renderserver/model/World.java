package server.reaptheflag.reaptheflag.renderserver.model;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class World {
    private static Set<OnlinePlayer> playres = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public World() {
    }

    public void update() {
        playres.removeIf((d) -> d.isDisConnected());
    }
}
