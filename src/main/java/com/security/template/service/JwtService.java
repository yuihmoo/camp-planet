package com.security.template.service;

import com.security.template.dto.response.AuthenticationResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    AuthenticationResponse generateAuthenticationResponse(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
