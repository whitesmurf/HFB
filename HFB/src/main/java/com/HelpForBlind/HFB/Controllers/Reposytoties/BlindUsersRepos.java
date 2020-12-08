package com.HelpForBlind.HFB.Controllers.Reposytoties;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BlindUsersRepos extends CrudRepository<BlindUsers,Long> {
    Optional<BlindUsers> findBlindUsersByEmail(String email);
}
