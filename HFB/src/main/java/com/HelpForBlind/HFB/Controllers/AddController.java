package com.HelpForBlind.HFB.Controllers;

import com.HelpForBlind.HFB.Controllers.Models.Articles;
import com.HelpForBlind.HFB.Controllers.Reposytoties.ArticlesRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddController  {

    private final ArticlesRepos articlesRepos;

    @Autowired
    public AddController(ArticlesRepos articlesRepos){
        this.articlesRepos = articlesRepos;
    }

    @GetMapping("/blog/add")
    public String Add(){
        return "Add";
    }

    @PostMapping("/Add")
    public String postAdd(@RequestParam String FIO,@RequestParam String subject,@RequestParam String topic,@RequestParam String content ){
        Articles article = new Articles(FIO,subject,topic,content);
           articlesRepos.save(article);

            return "redirect:/blog";
    }


}
