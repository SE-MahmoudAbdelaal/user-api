package com.fawry.user_api.service.impl;

import com.fawry.user_api.Exceptions.UserException;
import com.fawry.user_api.Mapper.UserAuthMapper;
import com.fawry.user_api.entity.User;
import com.fawry.user_api.entity.enums.Role;
import com.fawry.user_api.model.AuthenticationRequest;
import com.fawry.user_api.model.AuthenticationResponse;
import com.fawry.user_api.model.RegisterRequest;
import com.fawry.user_api.repository.UserRepository;
import com.fawry.user_api.security.JwtService;
import com.fawry.user_api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthMapper userAuthMapper;

    @Override
    public AuthenticationResponse register(RegisterRequest requestModel) {
        if (requestModel.getRole() == null) {
            requestModel.setRole(Role.USER);
        }

        if (requestModel.getRole().equals(Role.ADMIN)) {
            throw new UserException("Not allowed to register admin", HttpStatus.FORBIDDEN);
        }


        User user = userAuthMapper.toEntity(requestModel);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return userAuthMapper.toDTO(token);
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest requestModel) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestModel.getEmail(), requestModel.getPassword()));

            User user = userRepository
                    .findByEmail(requestModel.getEmail())
                    .orElseThrow(() -> new UserException("Incorrect email or password", HttpStatus.UNAUTHORIZED));

            String token = jwtService.generateToken(user);
            return userAuthMapper.toDTO(token);
        } catch (Exception e) {
            throw new UserException("Incorrect email or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
