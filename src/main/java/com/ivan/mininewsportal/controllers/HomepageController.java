package com.ivan.mininewsportal.controllers;

import com.ivan.mininewsportal.models.Keyword;
import com.ivan.mininewsportal.services.articleservice.ArticleService;
import com.ivan.mininewsportal.services.keywordservice.KeywordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class HomepageController {

    private final ArticleService articleService;
    private final KeywordService keywordService;

    public HomepageController(ArticleService articleService, KeywordService keywordService) {
        this.articleService = articleService;
        this.keywordService = keywordService;
    }

    @RequestMapping({"/", "homepage", ""})
    private String showHomepage(Model model) {

        Set<Keyword> findAllKeywords = keywordService.findAllKeywords();

        model.addAttribute("articles", articleService.findAllArticlePageable());
        model.addAttribute("keywords", findAllKeywords);

        return "homepage";

    }

}
