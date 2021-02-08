package com.HelpForBlind.HFB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = "/homepage",method = RequestMethod.GET)
    public String homepage(){
        return "Main";
    }
}
