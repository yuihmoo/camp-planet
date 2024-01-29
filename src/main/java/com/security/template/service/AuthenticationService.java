package com.security.template.service;

import com.security.template.dto.request.SignUpRequest;
import com.security.template.dto.request.LoginRequest;
import com.security.template.dto.response.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.lang.NonNull;

public interface AuthenticationService {
    AuthenticationResponse signup(SignUpRequest request);

    AuthenticationResponse login(LoginRequest request);

    void logout(@NonNull HttpServletRequest request);

    void saveRefreshTokenHistory(String loginId, String refreshToken);

    void deleteRefreshTokenHistory(String loginId);
}
