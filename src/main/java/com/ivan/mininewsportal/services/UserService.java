package com.ivan.mininewsportal.services;

import com.ivan.mininewsportal.models.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    void addUser(User user);

    void updateUser(Long id, User user);

    Set<User> findAllUsers();

    Optional<User> findUserById(Long id);


}
