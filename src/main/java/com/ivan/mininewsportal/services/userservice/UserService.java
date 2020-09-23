package com.ivan.mininewsportal.services.userservice;

import com.ivan.mininewsportal.models.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    void saveUser(User user); //this method add new or edit User

    Set<User> findAllUsers();

    Optional<User> findUserById(Long id);


}
