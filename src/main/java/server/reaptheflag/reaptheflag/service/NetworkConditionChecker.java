package server.reaptheflag.reaptheflag.service;

public class NetworkConditionChecker {
    private volatile boolean udpCondition = false;
    private static NetworkConditionChecker ourInstance = new NetworkConditionChecker();

    public static NetworkConditionChecker getInstance() {
        return ourInstance;
    }

    private NetworkConditionChecker() {
    }

    public void setUdpCondition(boolean condition) {
        this.udpCondition = condition;
    }

    public boolean getUdpCondition() {
        return udpCondition;
    }
}
