package com.ivan.mininewsportal.controllers;

import com.ivan.mininewsportal.models.Article;
import com.ivan.mininewsportal.models.User;
import com.ivan.mininewsportal.services.articleservice.ArticleService;
import com.ivan.mininewsportal.services.userservice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final UserService userService;

    public ArticleController(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @PostMapping("/savearticle")
    private String saveUser(@ModelAttribute Article article) {
        articleService.saveArticle(article);
        return "article_info";
    }

    @GetMapping("/info/{id}")
    private String articleInfo(@PathVariable("id") Long id, Model model) {
        Optional<Article> findArticle = articleService.findArticleById(id);

        if (findArticle.isPresent()) {
            findArticle.ifPresent(article -> model.addAttribute("article", article));
            return "article_info";
        } else {
            return "error_page";
        }


    }

    @GetMapping("/edit/{id}")
    private String editArticle(@PathVariable("id") Long id, Model model) {

        if (id <= 0) {
            model.addAttribute(new Article());

            List<User> users = userService.findAllUsers();
            model.addAttribute("users", users);

            return "article_form";
        } else {
            Optional<Article> getArticleById = articleService.findArticleById(id);
            List<User> users = userService.findAllUsers();

            if (getArticleById.isPresent()) {
                model.addAttribute("article", getArticleById);
                model.addAttribute("users", users);
                return "article_form";
            } else {
                return "error_page";
            }

        }


    }

    @GetMapping("/articlelist")
    private String listOfArticles(Model model) {

        List<Article> articleList = articleService.findAllArticle();
        model.addAttribute("articles", articleList);
        return "article_list";

    }

    @GetMapping("/search")
    private String showArticleByKeyword(@RequestParam(value = "search") String keyword, Model model) {
        List<Article> findArticleByKeyword = articleService.findArticleByKeyword(keyword);
        if (!keyword.isEmpty() && !findArticleByKeyword.isEmpty()) {
            model.addAttribute("search", findArticleByKeyword);
            return "article_search_by_keyword_list";

        } else {
            return "error_page";
        }
    }


}
