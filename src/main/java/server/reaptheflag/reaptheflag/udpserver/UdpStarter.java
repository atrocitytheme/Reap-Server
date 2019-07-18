package server.reaptheflag.reaptheflag.udpserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.service.NetworkConditionChecker;
/**
 * @see NetworkConditionChecker
 * udp server starter, with networkchecker involved
 * */

public class UdpStarter implements Runnable{
    private Logger LOGGER = LogManager.getLogger(UdpStarter.class);

    private UdpServer udpServer;
    @Autowired
    public void setNetworkConditionChecker(NetworkConditionChecker networkConditionChecker) {
        this.networkConditionChecker = networkConditionChecker;
    }

    public UdpStarter(UdpServer server) {
        this.udpServer = server;
    }

    private NetworkConditionChecker networkConditionChecker;

    @Override
    public void run() {
        NetworkConditionChecker validator = networkConditionChecker;
        try {
            udpServer.run();
        } catch (Exception e) {
            LOGGER.info("udp server initialization failed!\n");
            e.printStackTrace();
            validator.setUdpCondition(false);
        }
    }
}
