package com.fawry.user_api.service.impl;


import com.fawry.user_api.Exceptions.UserException;
import com.fawry.user_api.Mapper.UserMapper;
import com.fawry.user_api.entity.User;
import com.fawry.user_api.model.UserRegistrationDTO;
import com.fawry.user_api.repository.UserRepository;
import com.fawry.user_api.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserException("User Not Found ", HttpStatus.NOT_FOUND);
        }
        return user;
    }
}
