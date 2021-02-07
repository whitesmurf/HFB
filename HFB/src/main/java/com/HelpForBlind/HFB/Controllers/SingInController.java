package com.HelpForBlind.HFB.Controllers;

import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SingInController {
    private String error="";
    private final BlindUsersRepos blindUsersRepos;

    @Autowired
    public SingInController(@Qualifier("blindUsersRepos") BlindUsersRepos blindUsersRepos){
        this.blindUsersRepos = blindUsersRepos;
    }

    @RequestMapping(value = "/signIn",method = RequestMethod.GET)
    public String signIn(){
        return "SingIn";
    }

    @RequestMapping(value= "/signIn",method = RequestMethod.POST)
    public String signInPost(String email,String password){
        System.out.println(blindUsersRepos.findBlindUsersByEmail(email).get().getEmail());
        if(blindUsersRepos.findBlindUsersByEmail(email).isPresent() && blindUsersRepos.findBlindUsersByEmail(email).get().getPassword().equals(password))return"redirect:/Cabinet";
        else { error ="Invalid username or password" ;
            return "redirect:/signIn" ;}
    }
}
