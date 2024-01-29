package com.camp.planet.authentication.service;

import com.camp.planet.authentication.dto.request.LoginRequest;
import com.camp.planet.authentication.dto.request.SignUpRequest;
import com.camp.planet.authentication.dto.response.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.lang.NonNull;

public interface AuthenticationService {
    AuthenticationResponse signup(SignUpRequest request);

    AuthenticationResponse login(LoginRequest request);

    void logout(@NonNull HttpServletRequest request);

    void saveRefreshTokenHistory(String loginId, String refreshToken);

    void deleteRefreshTokenHistory(String loginId);
}
