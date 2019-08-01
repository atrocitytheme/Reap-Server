package server.reaptheflag.reaptheflag.gameserver.network;

import java.net.InetSocketAddress;
import java.util.Objects;

public abstract class NetworkUser {

    private boolean disconnected = false; // must use this to check connection status
    private double timeout; // must use this to decrement the number
    static final double CONNECTION_MAX_TIMEOUT = 5;

    private boolean spawned = false;

    public abstract int commandType(); // -1 for default
    public abstract String getIp(); // null for default
    public abstract String getName(); // null for default
    public abstract String getToken(); // null for default
    public abstract int getRoom(); // -1 for default
    public abstract int getPort(); // 5000 for default
    public abstract String getId(); // default is -1
    public abstract InetSocketAddress rawAddress();
    public abstract String getPassword();

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof NetworkUser)) return false;
        NetworkUser user = (NetworkUser) obj;
        return this.getId().equals(user.getId());
    }

    @Override
    public final int hashCode() {
        return  Objects.hash(getId());
    }
    // disconnect the user itself, when it's tcp, remember to override it to cut the tcp connection
    @Override
    public String toString() {
        return " ip: " + getIp() + " Name: " + getName() + " timeout: " + getTimeout() + "id: " + getId();
    }
    public void disconnect() {
        disconnected = true;
    }

    public boolean isSpawned() {
        return spawned;
    }

    public void setSpawned(boolean spawned) {
        this.spawned = spawned;
    }

    public final boolean isDisconnected() {
        return disconnected;
    }
    public final double getTimeout() {
        return timeout;
    }
    public final void setTimeout(double timeout) {
        this.timeout = timeout;
    }
    public final void decrementTimeout() {
        timeout -= 1;
    }
}
