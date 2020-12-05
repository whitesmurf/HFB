package com.HelpForBlind.HFB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SingInController {

    @GetMapping("/blog/singin")
    public String SingIn(){
        return "SingIn";
    }
}
