package com.ivan.mininewsportal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_generator")
    @SequenceGenerator(name = "article_generator", allocationSize = 5)
    private Long articleId;

    @NotEmpty(message = "Title required")
    private String title;

    @NotEmpty(message = "Text required")
    private String text;

    private LocalDateTime localDateTime = LocalDateTime.now();

    @ElementCollection
    private List<String> keywords = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
