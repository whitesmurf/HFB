package com.HelpForBlind.HFB.Controllers;



import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SingInController {

    @Autowired
     private BlindUsersRepos blindUsersRepos;

    @GetMapping("/singin")
    public String SingIn(){
        return "SingIn";
    }

    @PostMapping("/singin")
    public String PostSingin(@RequestParam String email,@RequestParam String password){
        blindUsersRepos.findBlindUsersByEmail(email);
        return "Add";
    }
}
