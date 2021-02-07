package com.HelpForBlind.HFB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CabinetController {

    @RequestMapping(value = "/Cabinet",method = RequestMethod.GET)
    public String cabinet(){
        return "Cabinet";
    }
}
