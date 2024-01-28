package com.security.template.service;

import com.security.template.dto.request.SignUpRequest;
import com.security.template.dto.request.LoginRequest;
import com.security.template.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse signup(SignUpRequest request);

    AuthenticationResponse login(LoginRequest request);
}
