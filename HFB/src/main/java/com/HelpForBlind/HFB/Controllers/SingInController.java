package com.HelpForBlind.HFB.Controllers;

import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingInController {
    private final BlindUsersRepos blindUserService;

    @Autowired
    public SingInController(BlindUsersRepos blindUserService){
        this.blindUserService = blindUserService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String signIn(){
        return "SignIn";
    }

    @RequestMapping(value= "/login",method = RequestMethod.POST)
    public String signInPost(@RequestParam String username, @RequestParam String password){
        System.out.println("Found");
        if(blindUserService.findBlindUsersByUsername(username).get().getPassword().equals(password)) return"/Cabinet";
        return "/SignIn";
    }
}
