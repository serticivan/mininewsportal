package com.ivan.mininewsportal.controllers;

import com.ivan.mininewsportal.models.User;
import com.ivan.mininewsportal.services.userservice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    private String addNewOrUpdateUser(@ModelAttribute @Validated User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user_form";
        } else {
            userService.saveUser(user);
            return "user_info";
        }

    }

    @GetMapping("/info/{id}")
    private String userInfo(@PathVariable("id") Long id, Model model) {
        Optional<User> findUser = userService.findUserById(id);
        findUser.ifPresent(user -> model.addAttribute("user", user));

        return "user_info";
    }

    @GetMapping("/edit/{id}")
    private String showUpdateForm(@PathVariable("id") Long id, Model model) {

        if (id <= 0) {
            model.addAttribute(new User());
            return "user_form";
        } else {
            Optional<User> user = userService.findUserById(id);

            if (user.isPresent()) {

                model.addAttribute("user", user.get());
                return "user_form";
            } else {
                return "error_page";
            }
        }

    }


}
