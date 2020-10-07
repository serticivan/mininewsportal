package com.ivan.mininewsportal.services.articleservice;

import com.ivan.mininewsportal.models.Article;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    void saveArticle(Article article); //method for add new or edit user

    List<Article> findAllArticle();

    Optional<Article> findArticleById(Long id);

    List<Article> findArticleByKeyword(String keyword);

    Page<Article> findAllArticlePageable();

}
