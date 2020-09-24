package com.ivan.mininewsportal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "keywords")
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "keyword_sequence")
    @SequenceGenerator(name = "keyword_sequence", allocationSize = 5)
    private Long keywordId;

    @NotEmpty(message = "Keyword name required!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

}
