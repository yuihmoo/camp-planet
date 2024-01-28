package com.security.template.service;

import com.security.template.dao.request.SignUpRequest;
import com.security.template.dao.request.LoginRequest;
import com.security.template.dao.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse signup(SignUpRequest request);

    AuthenticationResponse login(LoginRequest request);
}
