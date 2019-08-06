package server.reaptheflag.reaptheflag;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.middleware.GameSpaceManager;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.gameserver.network.TcpClientUser;
import server.reaptheflag.reaptheflag.gameserver.network.TokenNetworkUser;
import server.reaptheflag.reaptheflag.model.Player;

@SpringBootTest
public class MiddleManagerTest {
    @Test
    public void testMiddleRoomAdder() {
        NetworkSpace space = new NetworkSpace();
        GameSpaceManager manager = GameSpaceManager.getManager(space);
        space.allocateRoom(1);
        Player player = new Player();
        player.setId("BEACON");
        player.setPassword("12345");
        manager.addUserToRoom(player, 1);
        NetworkUser user = new TokenNetworkUser(player.getId(), "123");
        assertEquals(space.getLatestRoomId(), 1);
        assertFalse(space.getRoom(1).exists(user));
        NetworkUser user2 = new TokenNetworkUser(player.getId(), player.getPassword());
        assertTrue(space.getRoom(1).exists(user2));
    }
}
