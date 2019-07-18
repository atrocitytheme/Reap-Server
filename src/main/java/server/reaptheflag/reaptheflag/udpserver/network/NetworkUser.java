package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.network.sendable.SendableData;

import java.util.Objects;

public abstract class NetworkUser {
    public abstract int commandType();
    public abstract String getIp();
    public abstract String getName();
    public abstract void broadcast(SendableData data);
    public abstract String getToken();

    @Override
    public boolean equals(Object obj) {
        NetworkUser user = (NetworkUser) obj;

        return this.getIp().equals(user.getIp()) &&
                this.getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIp(), getName());
    }
}
