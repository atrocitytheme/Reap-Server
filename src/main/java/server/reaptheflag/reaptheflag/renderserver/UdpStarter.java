package server.reaptheflag.reaptheflag.renderserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import server.reaptheflag.reaptheflag.service.NetworkConditionChecker;
/**
 * @see NetworkConditionChecker
 * udp server starter, with networkchecker involved
 * */
public class UdpStarter implements Runnable{
    private int port;
    private ApplicationContext context;

    @Autowired
    public void setNetworkConditionChecker(NetworkConditionChecker networkConditionChecker) {
        this.networkConditionChecker = networkConditionChecker;
    }

    private NetworkConditionChecker networkConditionChecker;
    public UdpStarter(int port, ApplicationContext context) {
        this.port = port;
        this.context = context;
    }


    @Override
    public void run() {
        NetworkConditionChecker validator = networkConditionChecker;
        try {
            new UdpServer(port, context).run();
            validator.setUdpCondition(true);
        } catch (Exception e) {
            System.out.println("System initialization failed!");
        }
    }
}
