package com.HelpForBlind.HFB.Controllers;

import com.HelpForBlind.HFB.Controllers.Models.Articles;
import com.HelpForBlind.HFB.Controllers.Reposytoties.ArticlesRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogController {

    private final ArticlesRepos articlesRepos;

    @Autowired
    public BlogController(ArticlesRepos articlesRepos){
        this.articlesRepos = articlesRepos;
    }
    @GetMapping("/blog")
        public String blog(Model model){
            Iterable<Articles> article = articlesRepos.findAll();
            model.addAttribute("article",article);
            return "blog";
        }
    @GetMapping("/blog{id}")
    public String blogDetail(@PathVariable(value = "id") long id,Model model){
        Optional<Articles> article =articlesRepos.findById(id);
        ArrayList<Articles> result = new ArrayList<>();
        article.ifPresent(result::add);
        model.addAttribute("articles",result);
        return "blog-detail";
    }
    }





