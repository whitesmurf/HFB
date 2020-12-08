package com.HelpForBlind.HFB.Controllers.Models;

import javax.persistence.*;

@Entity
public class BlindUsers {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

     private String UserName,password,email;

    public long getId() {
        return id;
    }

    public BlindUsers() {
    }

    public BlindUsers(String userName, String password, String email) {
        UserName = userName;
        this.password = password;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
