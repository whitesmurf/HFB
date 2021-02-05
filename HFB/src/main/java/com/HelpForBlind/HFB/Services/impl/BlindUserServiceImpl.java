package com.HelpForBlind.HFB.Services.impl;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import com.HelpForBlind.HFB.Services.BlindUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BlindUserServiceImpl implements BlindUserService {

    private final BlindUsersRepos blindUsersRepos;

    @Autowired
    BlindUserServiceImpl(BlindUsersRepos blindUsersRepos){
        this.blindUsersRepos = blindUsersRepos;
    }

    @Override
    public void registerUser(BlindUsers blindUser) {
        blindUsersRepos.save(new BlindUsers(blindUser.getUsername(),blindUser.getPassword(),blindUser.getEmail()));
    }
}

