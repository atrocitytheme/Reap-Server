package server.reaptheflag.reaptheflag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.reaptheflag.reaptheflag.dao.players.PlayerDao;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.middleware.GameSpaceManager;
import server.reaptheflag.reaptheflag.model.Player;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @Autowired
    private NetworkSpace space;

    @ModelAttribute("player")
    public Player player(String name) {
        Player res = new Player();
        res.setCurrentDate(DateToolUtil.logCurrentDate());
        return res;
    }

    @Resource
    private PlayerDao playerDao;
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain")
    public String loginCheck(@ModelAttribute("player") Player player, HttpServletResponse res) {
        Player ep = playerDao.getPlayreById(player.getId());
        if (ep != null) {
            if (!ep.getPassword().equals(player.getPassword())) {
                res.setStatus(401);
                return "Password not matched!";
            }
            res.setStatus(200);
        } else {
            playerDao.insertPlayer(player);
            res.setStatus(200);
        }

        GameSpaceManager manager = GameSpaceManager.getManager(space);
        manager.createRoom(1);
        // register the room here
        int currentRoom = manager.getCurrentRoom();
        manager.addUserToRoom(player, currentRoom);

        return String.valueOf(currentRoom); // respond with the room id
    }
}
