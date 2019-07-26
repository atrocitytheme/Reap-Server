package server.reaptheflag.reaptheflag.gameserver.network.manager.broadcast;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.SendableData;

import java.io.IOException;
import java.net.*;

/**
 * @see BroadcastClientMachine
 * TODO: implement the udp protocal
 * */

@Service
public class UdpClientBroadcastClientMachine extends BroadcastClientMachine {
    private Logger LOGGER = LogManager.getLogger(UdpClientBroadcastClientMachine.class);

    @Autowired
    private NetworkSpace space;

    @Override
    public  void broadCast(NetworkUser client, SendableData data) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            LOGGER.error("socket set up failed");
            LOGGER.info(client + " imposed disconnection");
            space.disconnect(client);
            return;
        }
        byte[] sent = data.getBytes();
        InetAddress address = null;
        try {
            address = InetAddress.getByName(client.getIp());
        } catch (UnknownHostException e) {
            LOGGER.info("data sending stopped for: " + client);
            space.disconnect(client);
            return;
        }
/*
        DatagramPacket packet = new DatagramPacket(sent, sent.length, address, client.getPort());
*/
        DatagramPacket packet = new DatagramPacket(sent, sent.length, client.rawAddress());

        try {
            socket.send(packet);
            LOGGER.info("sent to address succeeds! " + client.rawAddress());
        } catch (IOException e) {
            LOGGER.error("pipes broken!" + e);
        }
    }
}
