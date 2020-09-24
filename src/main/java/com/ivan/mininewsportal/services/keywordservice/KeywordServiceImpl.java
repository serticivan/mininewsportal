package com.ivan.mininewsportal.services.keywordservice;

import com.ivan.mininewsportal.models.Keyword;
import com.ivan.mininewsportal.repositories.KeywordRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class KeywordServiceImpl implements KeywordService {

    private final KeywordRepository keywordRepository;

    public KeywordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public Keyword saveKeyword(Keyword keyword) {
        return keywordRepository.save(keyword);
    }

    @Override
    public Set<Keyword> findAllUsers() {
        return new HashSet<>(keywordRepository.findAll());
    }

    @Override
    public Optional<Keyword> findKeywordById(Long id) {
        return keywordRepository.findById(id);
    }
}
