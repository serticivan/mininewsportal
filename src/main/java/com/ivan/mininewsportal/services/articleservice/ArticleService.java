package com.ivan.mininewsportal.services.articleservice;

import com.ivan.mininewsportal.models.Article;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.Set;

public interface ArticleService {

    void saveArticle(Article article); //method for add new or edit user

    Set<Article> findAllArticle();

    Optional<Article> findArticleById(Long id);

    Set<Article> findArticleByKeyword(String keyword);

    Page<Article> findAllArticlePageable();

}
