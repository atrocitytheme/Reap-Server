package server.reaptheflag.reaptheflag.gameserver.game.modes.normal;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.game.tpyes.RoomType;
import server.reaptheflag.reaptheflag.gameserver.model.Alive;
import server.reaptheflag.reaptheflag.gameserver.model.OnlineObject;
import server.reaptheflag.reaptheflag.gameserver.model.OnlinePlayer;
import server.reaptheflag.reaptheflag.gameserver.model.logic.KeyFrame;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.TcpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.sendable.converter.JsonFormatConverter;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NormalRoom extends NetworkRoom {
    private Logger LOGGER = LogManager.getLogger(NormalRoom.class);
    private Set<NetworkUser> diedPlayers = Collections.synchronizedSet(new HashSet<>());
    public void exitPlayer(NetworkUser user) {

        tcpData.remove(user);
        udpData.remove(user);
        basicPool.remove(user);
        diedPlayers.remove(user);
    }

    public void die(NetworkUser user) {
        diedPlayers.add(user);
    }

    public boolean isDead(NetworkUser user) {
        return diedPlayers.contains(user);
    }

    @Override
    public void updateUdpInfo(NetworkUser user, OnlineObject model) {
        OnlinePlayer playerModel = (OnlinePlayer) model;
        if (isDead(user)) {
            playerModel.setDead(true);
        }

        else {
            playerModel.setDead(false);
        }
        super.updateUdpInfo(user, model);
    }

    @Override
    public void writeFrameToAllExcept(NetworkUser user, KeyFrame data) {
        Set<NetworkUser> allUsers = getAllTcpUsers();
        TcpClientUser tcpClientUser = (TcpClientUser) user;
        LOGGER.info("writing to: " + tcpClientUser.getNetworkCondition().channel().remoteAddress());
        LOGGER.info("opened: " + tcpClientUser.getNetworkCondition().channel().isOpen());
        JsonFormatConverter converter = new JsonFormatConverter(data);
        allUsers.parallelStream().filter((u)-> !u.equals(tcpClientUser)).forEach((u) -> {
            String sendable = converter.convertToSendable();
            TcpClientUser tcpUserCurrent = (TcpClientUser) u;
            ChannelHandlerContext ctx = tcpUserCurrent.getNetworkCondition();
            squeezeWithHead(tcpUserCurrent, sendable.getBytes().length, sendable, 5);
        });
    }

    private ByteBuf getBytes(String data) {
        return Unpooled.copiedBuffer(data.getBytes());
    }

    // send the int message for the data
    private void squeezeWithHead(TcpClientUser user, int length, String data, int retry) {
        if (retry < 0) {
            return;
        }

        if (!user.getNetworkCondition().channel().isWritable()) {
            squeezeWithHead(user, length, data, retry - 1);
            return;
        }
        ChannelHandlerContext stream = user.getNetworkCondition();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byteStream.write(length & 0xff);
        byteStream.write((length >> 8) & 0xff);
        byteStream.write((length >> 16) & 0xff);
        byteStream.write((length >> 24) & 0xff);
        byte[] l = byteStream.toByteArray();
        try {
            stream.channel().writeAndFlush(Unpooled.copiedBuffer(l)).addListener(ChannelFutureListener.CLOSE_ON_FAILURE).sync();
            stream.channel().writeAndFlush(getBytes(data)).addListener(ChannelFutureListener.CLOSE_ON_FAILURE).sync();
        }

        catch (InterruptedException e) {
            squeezeWithHead(user, length, data, retry - 1);
        }
    }
    @Override
    public RoomType roomType() {
        return RoomType.NORMAL;
    }
}
