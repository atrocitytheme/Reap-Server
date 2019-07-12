package server.reaptheflag.reaptheflag.renderserver;

public class UdpStarter implements Runnable{
    private int port;
    public UdpStarter(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println("Udp Server initialized!");
    }
}
