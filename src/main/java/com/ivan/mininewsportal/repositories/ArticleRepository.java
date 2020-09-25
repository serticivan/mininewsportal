package com.ivan.mininewsportal.repositories;

import com.ivan.mininewsportal.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Set<Article> findByKeywords(String keyword);

}
