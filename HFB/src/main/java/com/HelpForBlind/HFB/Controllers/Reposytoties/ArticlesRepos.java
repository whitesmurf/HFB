package com.HelpForBlind.HFB.Controllers.Reposytoties;

import com.HelpForBlind.HFB.Controllers.Models.Articles;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticlesRepos extends CrudRepository<Articles, Long> {
    Optional<Articles> findArticlesBySubject(String subject);
}
