package com.ivan.mininewsportal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

//    @OneToMany(mappedBy = "article",fetch = FetchType.EAGER)
//    private Set<Keyword> keywords = new HashSet<>();

}
