package com.ivan.mininewsportal.services.keywordservice;

import com.ivan.mininewsportal.models.Keyword;

import java.util.Optional;
import java.util.Set;

public interface KeywordService {

    Keyword saveKeyword(Keyword keyword);

    Set<Keyword> findAllKeywords();

    Optional<Keyword> findKeywordById(Long id);

}
