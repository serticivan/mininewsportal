package com.ivan.mininewsportal.services;

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
    public void addUser(User user) {
        userRepository.save(user);
        System.out.println("User with id: " + user.getUserId() + " added");
    }

    @Override
    public Set<User> findAllUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public User updateUser(Long id) {
        return findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));

    }
}
