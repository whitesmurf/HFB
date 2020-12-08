package com.HelpForBlind.HFB.Controllers.Reposytoties;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import org.springframework.data.repository.CrudRepository;

public interface BlindUsersRepos extends CrudRepository<BlindUsers,Long> {
}
