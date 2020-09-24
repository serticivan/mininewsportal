package com.ivan.mininewsportal.controllers;

import com.ivan.mininewsportal.services.articleservice.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

    private final ArticleService articleService;

    public HomepageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping({"/", "homepage", ""})
    private String showHomepage(Model model) {

        model.addAttribute("articles", articleService.findAllArticlePageable());

        return "homepage";

    }

}
