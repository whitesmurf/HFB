package com.HelpForBlind.HFB.Controllers;

import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(value = "localhost:8082", methods = {RequestMethod.GET, RequestMethod.POST})
public class SingInController {
    private final BlindUsersRepos blindUsersRepos;

    @Autowired
    public SingInController(@Qualifier("blindUsersRepos") BlindUsersRepos blindUsersRepos){
        this.blindUsersRepos = blindUsersRepos;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String signIn(){
        return "SignIn";
    }

    @RequestMapping(value= "/login",method = RequestMethod.POST)
    public String signInPost(@RequestParam String email, @RequestParam String password){
        System.out.println("Found");
        if(blindUsersRepos.findBlindUsersByEmail(email).isPresent() && blindUsersRepos.findBlindUsersByEmail(email).get().getPassword().equals(password))return"redirect:/Cabinet";
        return "/SignIn";
    }
}
