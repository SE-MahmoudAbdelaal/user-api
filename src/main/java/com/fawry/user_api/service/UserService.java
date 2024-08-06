package com.fawry.user_api.service;


import com.fawry.user_api.entity.User;
import com.fawry.user_api.model.UserRegistrationDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(UserRegistrationDTO userRegistrationDTO);
    List<User> getUsers();
    Optional<User> getUser(Long id);
}
