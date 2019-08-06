package server.reaptheflag.reaptheflag.gameserver.middleware;

import server.reaptheflag.reaptheflag.gameserver.game.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.network.TokenNetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.model.Player;
/**
 * This package provides tools to link gameserver and http service
 * */
public class GameSpaceManager {
    private static int MAX_NUM_OF_PLAYERS_IN_ONE_ROOM = 10;
    private NetworkSpace space;

    public static GameSpaceManager getManager(NetworkSpace space) {
        return new GameSpaceManager(space);
    }

    private GameSpaceManager(NetworkSpace space) {
        this.space = space;
    }

    public void createRoom(int roomType) {
        if (space.getLatestRoomId() == 0) {
            space.allocateRoom(roomType);
            return;
        }
        if (space.getRoom(space.getLatestRoomId()) == null) {
            space.allocateRoom(roomType);
            return;
        }
        if (space.getRoom(space.getLatestRoomId()).totalPlayer() < MAX_NUM_OF_PLAYERS_IN_ONE_ROOM) {
            return;
        }
        space.allocateRoom(roomType);
    }

    public void addUserToRoom(Player player, int roomId) {
        NetworkRoom room = space.getRoom(roomId);
        NetworkUser basic = new TokenNetworkUser(player.getId(), player.getPassword());
        room.joinPlayer(basic);
    }

    public int getCurrentRoom() {
        return space.getLatestRoomId();
    }
    NetworkSpace getRawSpace() {
        return space;
    }
}
