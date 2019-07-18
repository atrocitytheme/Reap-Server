package server.reaptheflag.reaptheflag.udpserver.network.sendable;
/**
 * Packet that's sent to the address, including: packet types, ip, data body
 * */
public class SentDataPacketUdp<T> extends SendableData{
    T prototype;

    public T getPrototype() {
        return prototype;
    }

    public void setPrototype(T prototype) {
        this.prototype = prototype;
    }


}
