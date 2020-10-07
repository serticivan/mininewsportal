package com.ivan.mininewsportal.services.articleservice;

import com.ivan.mininewsportal.models.Article;
import com.ivan.mininewsportal.repositories.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public List<Article> findAllArticle() {
        return articleRepository.findAll();

    }

    @Override
    public Page<Article> findAllArticlePageable() {
        return articleRepository
                .findAll(PageRequest.of(0, 10, Sort.by(Sort.Order.desc("showAddOrUpdatedArticleDate"))));
    }

    @Override
    public Optional<Article> findArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Transactional
    @Override
    public List<Article> findArticleByKeyword(String keyword) {
        return articleRepository.findAllByKeywords(keyword);
    }
}
