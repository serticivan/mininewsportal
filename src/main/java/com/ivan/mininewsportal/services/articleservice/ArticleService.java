package com.ivan.mininewsportal.services.articleservice;

import com.ivan.mininewsportal.models.Article;

import java.util.Optional;
import java.util.Set;

public interface ArticleService {

    void saveArticle(Article article); //method for add new or edit user

    Set<Article> findAllArticle();

    Optional<Article> findArticleById(Long id);

}
