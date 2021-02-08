package com.HelpForBlind.HFB.Controllers;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Enums.Role;
import com.HelpForBlind.HFB.Enums.Status;
import com.HelpForBlind.HFB.Services.BlindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(value = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class SingUpController {

    private final BlindUserService blindUserService;

    @Autowired
    public SingUpController(@Qualifier("blindUserServiceImpl") BlindUserService blindUserService) {
        this.blindUserService = blindUserService;
    }

    @GetMapping("/signUp")
    public String SingUp(){
        return "SignUp";
    }

    @RequestMapping(value = "/signUp" , method = RequestMethod.POST)
    public String AddUser(@RequestParam String UserName,@RequestParam String password,@RequestParam String email){
       BlindUsers BlindUser = new BlindUsers(UserName,password,email,Role.ADMIN,Status.ACTIVE);
        blindUserService.registerUser(BlindUser);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(BlindUser.getUsername(),BlindUser.getPassword(), List.of(new SimpleGrantedAuthority(BlindUser.getRole().name()))));
        return"Main";
    }
}
