package com.ivan.mininewsportal.repositories;

import com.ivan.mininewsportal.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
