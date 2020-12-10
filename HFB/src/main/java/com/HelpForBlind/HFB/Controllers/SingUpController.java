package com.HelpForBlind.HFB.Controllers;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingUpController {

    private final BlindUsersRepos blindUsersRepos;

    @Autowired
    public SingUpController(BlindUsersRepos blindUsersRepos){
        this.blindUsersRepos = blindUsersRepos;
    }

    @GetMapping("/singup")
    public String SingUp(){
        return "SingUP";
    }
    @PostMapping("reg")
    private String AddUser(@RequestParam String UserName,@RequestParam String password,@RequestParam String email){
       BlindUsers BlindUser = new BlindUsers(UserName,password,email);
        blindUsersRepos.save(BlindUser);
        return"Main";
    }
}
