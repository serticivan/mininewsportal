package com.ivan.mininewsportal.controllers;

import com.ivan.mininewsportal.models.Keyword;
import com.ivan.mininewsportal.services.keywordservice.KeywordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/keyword")
public class KeywordController {

    private final KeywordService keywordService;

    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @GetMapping("/showkeywordform")
    private String showKeywordForm(Model model) {
        model.addAttribute(new Keyword());

        return "keyword_form";
    }

    @PostMapping("/savekeyword")
    private String saveKeyword(@ModelAttribute Keyword keyword) {
        keywordService.saveKeyword(keyword);
        return "keyword_info";
    }

    @GetMapping("/infokeyword/{id}")
    private String keywordInfo(@PathVariable("id") Long id, Model model) {
        Optional<Keyword> keywordOptional = keywordService.findKeywordById(id);
        keywordOptional.ifPresent(keyword -> model.addAttribute("keyword", keyword));
        return "keyword_info";
    }

    @GetMapping("/edit/{id}")
    private String editKeyword(@PathVariable("id") Long id, Model model) {

        Optional<Keyword> keywordOptional = keywordService.findKeywordById(id);

        model.addAttribute("keyword", keywordOptional);

        return "keyword_form";
    }
}
