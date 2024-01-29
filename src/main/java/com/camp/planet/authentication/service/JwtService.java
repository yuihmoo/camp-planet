package com.camp.planet.authentication.service;

import com.camp.planet.authentication.dto.response.AuthenticationResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    AuthenticationResponse generateAuthenticationResponse(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
