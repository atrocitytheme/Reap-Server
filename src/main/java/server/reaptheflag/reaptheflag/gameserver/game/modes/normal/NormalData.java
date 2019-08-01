package server.reaptheflag.reaptheflag.gameserver.game.modes.normal;

import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class NormalData {
    private final List<NetworkUser> killed = new ArrayList<>();

    public void addKill(NetworkUser other) {
        synchronized (killed) {
            killed.add(other);
        }
    }

    public int getKillCount() {
        return killed.size();
    }

    public List<NetworkUser> getKilled() {
        return killed;
    }
}
