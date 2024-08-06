package com.fawry.user_api.service;


import com.fawry.user_api.entity.User;
import com.fawry.user_api.model.UserRegistrationDTO;

import java.util.List;

public interface UserService {

    void createUser(UserRegistrationDTO userRegistrationDTO);
    User updateUser(UserRegistrationDTO userRegistrationDTO);
    List<User> getUsers();
}
