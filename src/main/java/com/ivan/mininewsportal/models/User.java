package com.ivan.mininewsportal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", allocationSize = 5)
    private Long userId;

    @NotEmpty(message = "First name required")
    private String firstName;

    @NotEmpty(message = "Last name required")
    private String lastName;

    @NotEmpty(message = "Email required")
    private String email;

    @NotEmpty(message = "Password required")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Article> articleList = new HashSet<>();


}
