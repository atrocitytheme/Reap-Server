package server.reaptheflag.reaptheflag.service;

import org.springframework.stereotype.Service;

@Service
public class NetworkConditionChecker {
    private volatile boolean udpCondition = false;
    public void setUdpCondition(boolean condition) {
        this.udpCondition = condition;
    }
    public boolean getUdpCondition() {
        return udpCondition;
    }
}
