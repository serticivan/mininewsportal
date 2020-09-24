package com.ivan.mininewsportal.repositories;

import com.ivan.mininewsportal.models.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
