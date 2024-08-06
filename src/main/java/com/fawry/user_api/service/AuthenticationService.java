package com.fawry.user_api.service;

import com.fawry.user_api.model.AuthenticationRequest;
import com.fawry.user_api.model.AuthenticationResponse;
import com.fawry.user_api.model.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest requestModel);

    AuthenticationResponse login(AuthenticationRequest requestModel);
}
