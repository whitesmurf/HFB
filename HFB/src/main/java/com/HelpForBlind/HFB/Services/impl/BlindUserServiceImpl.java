package com.HelpForBlind.HFB.Services.impl;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import com.HelpForBlind.HFB.Enums.Role;
import com.HelpForBlind.HFB.Enums.Status;
import com.HelpForBlind.HFB.Services.BlindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlindUserServiceImpl implements BlindUserService {

    private final BlindUsersRepos blindUsersRepos;

    @Autowired
    BlindUserServiceImpl(BlindUsersRepos blindUsersRepos){
        this.blindUsersRepos = blindUsersRepos;
    }

    @Override
    public void registerUser(BlindUsers blindUser) {
        blindUsersRepos.save(new BlindUsers(blindUser.getUsername(),blindUser.getPassword(),blindUser.getEmail(),blindUser.getRole(),blindUser.getStatus()));
    }
}

