package server.reaptheflag.reaptheflag.gameserver.context.rooms.modes;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.model.logic.KeyFrame;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.TcpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.converter.JsonFormatConverter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

public class NormalRoom extends NetworkRoom {
    private Logger LOGGER = LogManager.getLogger(NormalRoom.class);
    private Set<NetworkUser> diedPlayers = Collections.synchronizedSet(new HashSet<>());
    public void die(NetworkUser user) {
        diedPlayers.add(user);
        udpData.remove(user); // no more udp sent to the user
    }

    public boolean isDead(NetworkUser user) {
        return diedPlayers.contains(user);
    }

    @Override
    public void updateUdpInfo(NetworkUser user, OnlineObject model) {
        if (!isDead(user)) {
            super.updateUdpInfo(user, model);
        }
    }

    @Override
    public void writeFrameToUser(NetworkUser user, KeyFrame data) {
        Set<NetworkUser> allUsers = getAllTcpUsers();
        TcpClientUser tcpClientUser = (TcpClientUser) user;
        LOGGER.info("writing to: " + tcpClientUser.getNetworkCondition().channel().remoteAddress());
        LOGGER.info("opened: " + tcpClientUser.getNetworkCondition().channel().isOpen());
        JsonFormatConverter converter = new JsonFormatConverter(data);
            allUsers.parallelStream().filter((u)-> !u.equals(user)).forEach((u) -> {
                if (tcpConnected(user)) {
                    ChannelFuture future = tcpClientUser.getNetworkCondition().writeAndFlush(getBytes(converter.convertToSendable()));
                    future.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                }
        });
    }

    private byte[] getBytes(String data) {
        return data.getBytes();
    }
}
