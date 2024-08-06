package com.fawry.user_api.controller;


import com.fawry.user_api.entity.User;
import com.fawry.user_api.model.UserRegistrationDTO;
import com.fawry.user_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@Validated @RequestBody UserRegistrationDTO userRegistrationDTO) {
        userService.createUser(userRegistrationDTO);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
