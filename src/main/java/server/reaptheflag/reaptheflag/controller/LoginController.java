package server.reaptheflag.reaptheflag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.reaptheflag.reaptheflag.dao.players.PlayerDao;
import server.reaptheflag.reaptheflag.model.Player;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

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
        if (playerDao.getPlayreById(player.getId()) != null) {
            res.setStatus(401);
            return "no!";
        }
        playerDao.insertPlayer(player);
        res.setStatus(200);
        return "congratulations!";
    }
}
