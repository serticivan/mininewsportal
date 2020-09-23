package com.ivan.mininewsportal.controllers;

import com.ivan.mininewsportal.models.Article;
import com.ivan.mininewsportal.services.articleservice.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping({"/showArticleForm", "/showarticleform"})
    private String showArticleForm(Model model) {
        model.addAttribute(new Article());
        return "article_form";
    }

    @PostMapping("/savearticle")
    private String saveUser(@ModelAttribute Article article) {
        articleService.saveArticle(article);
        return "article_info";
    }

    @GetMapping("/edit/{id}")
    private String editArticle(@PathVariable("id") Long id, Model model) {

        Optional<Article> getArticleById = articleService.findArticleById(id);

        if (getArticleById.isPresent()) {
            model.addAttribute("article", getArticleById);
            return "article_form";
        } else {
            return "error_page";
        }


    }


}
