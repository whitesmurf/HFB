package com.HelpForBlind.HFB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddController  {

    @GetMapping("/blog/add")
    public String Add(){
        return "Add";
    }

    @PostMapping("/Add")
    public String postAdd( ){

            return "redirect:blog";
    }


}
