package com.security.template.service;

import com.security.template.dao.request.SignUpRequest;
import com.security.template.dao.request.LoginRequest;
import com.security.template.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(LoginRequest request);
}
