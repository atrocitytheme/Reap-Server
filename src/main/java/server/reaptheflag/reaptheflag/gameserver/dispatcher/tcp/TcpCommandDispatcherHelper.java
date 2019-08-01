package server.reaptheflag.reaptheflag.gameserver.dispatcher.tcp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.game.tpyes.RoomType;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.*;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.normal.NormalRoomDieCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.normal.NormalRoomDisconnectCommand;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.normal.SpreadDataCommand;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

@Component
public class TcpCommandDispatcherHelper {
    private static Logger LOGGER = LogManager.getLogger(TcpCommandDispatcherHelper.class);
    public Command taleCommand(NetworkUser user, NetworkSpace space) {

        if (space.getRoom(user.getRoom()) == null) {
            LOGGER.info(user + "  invalid tcp command detected");
            return new DisconnectCommand();
        }

        NetworkRoom room = space.getRoom((user.getRoom()));
        // if not in this room
        if (!room.exists(user)) {
            LOGGER.info(user + " tcp requests: want to hack into this room with id: " + user.getRoom());
            return new DisconnectCommand();
        }

        if (user.commandType() == 101) {
            LOGGER.info(user.rawAddress() + " is testing connection");
            return new ConnectionCommand();
        }

        if (user.commandType() == 6) {
            if (space.getRoom(user.getRoom()).roomType() == RoomType.VOID) {
                return new DieCommand();
            }

            if (space.getRoom(user.getRoom()).roomType() == RoomType.NORMAL) {
                return new NormalRoomDieCommand();
            }
        }

        if (user.commandType() == 7) {

            if (space.getRoom(user.getRoom()).roomType() == RoomType.NORMAL) {
                return new SpreadDataCommand();
            }
        }

        if (user.commandType() == 11) {
            if(space.getRoom(user).roomType() == RoomType.NORMAL) {
                return new NormalRoomDisconnectCommand();
            }
        }

        return new NullCommand();
    }

}
