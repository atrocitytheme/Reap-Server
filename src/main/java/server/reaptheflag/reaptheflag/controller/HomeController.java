package server.reaptheflag.reaptheflag.controller;

import org.springframework.web.bind.annotation.*;
import server.reaptheflag.reaptheflag.dao.players.PlayerDao;
import server.reaptheflag.reaptheflag.model.Player;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String indexPage() {
        return "Welcome to the game serverboot";
    }
}
