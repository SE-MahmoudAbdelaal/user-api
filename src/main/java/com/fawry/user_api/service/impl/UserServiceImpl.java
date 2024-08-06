package com.fawry.user_api.service.impl;


import com.fawry.user_api.Mapper.UserMapper;
import com.fawry.user_api.entity.User;
import com.fawry.user_api.model.UserRegistrationDTO;
import com.fawry.user_api.repository.UserRepository;
import com.fawry.user_api.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public void createUser(UserRegistrationDTO userRegistrationDTO) {
        User user = UserMapper.INSTANCE.toEntity(userRegistrationDTO);

        userRepository.save(user);
    }


    @Override
    public User updateUser(UserRegistrationDTO userRegistrationDTO) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
