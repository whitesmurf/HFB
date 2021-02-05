package com.HelpForBlind.HFB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String homepage(){
        return "Main";
    }
}
