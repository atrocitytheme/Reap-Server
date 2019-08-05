package server.reaptheflag.reaptheflag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * normal controller is mainly used for GUI interface to manage games and monitor game status
 * */
@RestController
public class NormalController {

    @RequestMapping("/adminLogin")
    public String login() {
        return "login";
    }
}
