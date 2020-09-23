package com.ivan.mininewsportal.services.articleservice;

import com.ivan.mininewsportal.models.Article;
import com.ivan.mininewsportal.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Set<Article> findAllArticle() {
        return new HashSet<>(articleRepository.findAll());

    }

    @Override
    public Optional<Article> findArticleById(Long id) {
        return articleRepository.findById(id);
    }


}
