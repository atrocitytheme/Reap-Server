package server.reaptheflag.reaptheflag.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String indexPage() {
            return "Welcome to the game server";
            }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain")
    public String loginCheck(HttpServletResponse res) {
            res.setStatus(200);
            return "congratulations!";
    }
}
