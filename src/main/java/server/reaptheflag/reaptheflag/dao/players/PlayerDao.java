package server.reaptheflag.reaptheflag.dao.players;

import server.reaptheflag.reaptheflag.model.Player;

import java.util.List;

public interface PlayerDao {
    Player getPlayreById(int id);

    List<Player> queryPlayerByName(String name);
    List<Player> getALLPlayers();

    void deletePlayer(int id);
    <T> void updatePlayer(int id, String attribute, T v1, T v2);
}
