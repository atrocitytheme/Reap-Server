package server.reaptheflag.reaptheflag.udpserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import server.reaptheflag.reaptheflag.service.NetworkConditionChecker;
import server.reaptheflag.reaptheflag.udpserver.server.Startable;
import server.reaptheflag.reaptheflag.udpserver.server.UdpServer;

/**
 * @see NetworkConditionChecker
 * udp server starter, with networkchecker involved
 * */

public class Starter implements Runnable{
    private Logger LOGGER = LogManager.getLogger(Starter.class);

    private Startable startableObj;

    @Autowired
    public void setNetworkConditionChecker(NetworkConditionChecker networkConditionChecker) {
        this.networkConditionChecker = networkConditionChecker;
    }

    public Starter(Startable server) {
        this.startableObj = server;
    }

    private NetworkConditionChecker networkConditionChecker;

    @Override
    public void run() {
        NetworkConditionChecker validator = networkConditionChecker;
        try {
            startableObj.run();
        } catch (Exception e) {
            LOGGER.info("tcp/udp server initialization failed!\n");
            LOGGER.error(e);
            validator.setUdpCondition(false);
        }
    }
}
