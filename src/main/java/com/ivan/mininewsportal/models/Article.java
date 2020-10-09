package com.ivan.mininewsportal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_sequence")
    @SequenceGenerator(name = "article_sequence", allocationSize = 5)
    private Long articleId;

    @NotEmpty(message = "Title required")
    private String title;

    @Lob
    @NotEmpty(message = "Text required")
    private String text;

    private LocalDateTime showAddOrUpdatedArticleDate = LocalDateTime.now();

    @ElementCollection
    private List<String> keywords = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull(message = "User required. Please make new User first!")
    private User user;

}
