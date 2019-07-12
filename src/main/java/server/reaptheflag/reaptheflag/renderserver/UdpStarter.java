package server.reaptheflag.reaptheflag.renderserver;

import server.reaptheflag.reaptheflag.service.NetworkConditionChecker;

public class UdpStarter implements Runnable{
    private int port;

    public UdpStarter(int port) {
        this.port = port;
    }


    @Override
    public void run() {
        NetworkConditionChecker validator = NetworkConditionChecker.getInstance();
        try {
            new UdpServer(port).run();
            validator.setUdpCondition(true);
        } catch (Exception e) {
            System.out.println("System initialization failed!");
        }
    }
}
