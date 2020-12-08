package com.HelpForBlind.HFB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class SingInController {

    @GetMapping("/blog/singin")
    public String SingIn(){
        return "SingIn";
    }

    @PutMapping("/blog/singin")
    public String PostSingin(){
        return "redirect:/blog/add";
    }
}
