package com.HelpForBlind.HFB.Security;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Controllers.Reposytoties.BlindUsersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlindUserDEtailsServiceImpl implements UserDetailsService {

    private final BlindUsersRepos BLindUserRepository;

    @Autowired
    BlindUserDEtailsServiceImpl(BlindUsersRepos blindUserRepository){
        this.BLindUserRepository = blindUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BlindUsers blindUser = BLindUserRepository.findBlindUsersByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user do not exist"));
        return BlindUserDetails.fromUser(blindUser);
    }
}
