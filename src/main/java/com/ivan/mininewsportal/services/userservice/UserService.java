package com.ivan.mininewsportal.services.userservice;

import com.ivan.mininewsportal.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(User user); //this method add new or edit User

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);


}
