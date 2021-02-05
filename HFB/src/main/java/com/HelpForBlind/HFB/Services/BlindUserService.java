package com.HelpForBlind.HFB.Services;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import org.springframework.stereotype.Service;

@Service
public interface BlindUserService {
    void registerUser(BlindUsers blindUsers);
}
