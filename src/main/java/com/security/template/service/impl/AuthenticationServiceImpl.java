package com.security.template.service.impl;

import com.security.template.dao.request.SignUpRequest;
import com.security.template.dao.request.LoginRequest;
import com.security.template.dao.response.JwtAuthenticationResponse;
import com.security.template.entities.Role;
import com.security.template.entities.User;
import com.security.template.repository.UserRepository;
import com.security.template.service.AuthenticationService;
import com.security.template.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .name(request.getName())
                .loginId(request.getLoginId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .phone(request.getPhone())
                .createdDate(LocalDateTime.now())
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword()));
        var user = userRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
