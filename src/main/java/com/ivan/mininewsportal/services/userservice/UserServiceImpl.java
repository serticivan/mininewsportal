package com.ivan.mininewsportal.services.userservice;

import com.ivan.mininewsportal.models.User;
import com.ivan.mininewsportal.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
        System.out.println("User with id: " + user.getUserId() + " added");
    }

    @Override
    public Set<User> findAllUsers() {

        return new HashSet<>(userRepository.findAll());

    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }


}
