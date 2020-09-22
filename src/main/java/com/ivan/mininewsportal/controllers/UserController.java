package com.ivan.mininewsportal.controllers;

import com.ivan.mininewsportal.models.User;
import com.ivan.mininewsportal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showUserForm")
    private String showUserForm(Model model) {
        model.addAttribute(new User());
        return "user_form";
    }

    @PostMapping("/save")
    private String addNewUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "user_info";
    }

    @GetMapping("/info/{id}")
    private String userInfo(@PathVariable("id") Long id, Model model) {
        Optional<User> findUser = userService.findUserById(id);
        findUser.ifPresent(user -> model.addAttribute("user", user));

        return "user_info";
    }

    @GetMapping("/edit/{id}")
    private String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));

        model.addAttribute("user", user);
        return "user_form";
    }


}
