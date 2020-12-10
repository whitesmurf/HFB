package com.HelpForBlind.HFB.Controllers;



import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Controller
public class SingInController {


     private final BlindUsersRepos blindUsersRepos;
    @Autowired
    public SingInController(BlindUsersRepos blindUsersRepos){
        this.blindUsersRepos = blindUsersRepos;
    }

    @GetMapping("/singin")
    public String SingIn(){
        return "SingIn";
    }

    @PostMapping("aut")
    public String PostSingIn(@RequestParam String email,@RequestParam String password){
           if (blindUsersRepos.findBlindUsersByEmail(email).isPresent()) {
               if (blindUsersRepos.findBlindUsersByEmail(email).get().getPassword().equals(password))
                   return "redirect:/blog/add";
               else
                   return "SingIn";
           }
           else return "SingIn";
    }
}
