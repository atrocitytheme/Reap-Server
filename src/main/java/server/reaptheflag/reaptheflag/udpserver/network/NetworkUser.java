package server.reaptheflag.reaptheflag.udpserver.network;

import server.reaptheflag.reaptheflag.udpserver.network.sendable.SendableData;

import java.util.Objects;

public abstract class NetworkUser {

    private boolean disconnected = false; // must use this to check connection status
    private double timeout; // must use this to decrement the number
    static final double CONNECTION_MAX_TIMEOUT = 5;

    public abstract int commandType(); // -1 for default
    public abstract String getIp(); // null for default
    public abstract String getName(); // null for default
    public abstract String getToken(); // null for default
    public abstract int getRoom(); // -1 for default
    public abstract int getPort(); // 5000 for default

    @Override
    public boolean equals(Object obj) {
        Class<?> c = getClass();
        Class<?> m = obj.getClass();
        if (!getClass().equals(obj.getClass())) return false;

        if (obj == null) return false;
        NetworkUser user = (NetworkUser) obj;
        return this.getIp().equals(user.getIp()) &&
                this.getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getIp(), getName(), getRoom());
        return result;
    }
    // disconnect the user itself, when it's tcp, remember to override it to cut the tcp connection
    public void disconnect() {
        disconnected = true;
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
