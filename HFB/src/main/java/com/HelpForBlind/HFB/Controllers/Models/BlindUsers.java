package com.HelpForBlind.HFB.Controllers.Models;

import com.HelpForBlind.HFB.Enums.Role;
import com.HelpForBlind.HFB.Enums.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BlindUsers {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

     private String username,password,email;
     Role role;
     Status status;

    public BlindUsers() {
    }

    public BlindUsers(String userName, String password, String email,Role role,Status status) {
        this.username = userName;
        this.password = password;
        this.email = email;
        this.status = status;
        this.role = role;
    }

}
