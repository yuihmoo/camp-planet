package com.security.template.service.impl;

import com.security.template.dto.request.SignUpRequest;
import com.security.template.dto.request.LoginRequest;
import com.security.template.dto.response.AuthenticationResponse;
import com.security.template.constant.Role;
import com.security.template.entity.User;
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
    public AuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .name(request.getName())
                .loginId(request.getLoginId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .phone(request.getPhone())
                .createdDate(LocalDateTime.now())
                .role(Role.USER).build();
        userRepository.save(user);
        return jwtService.generateAuthenticationResponse(user);
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword()));
        var user = userRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호를 다시 확인해주세요."));
        return jwtService.generateAuthenticationResponse(user);
    }
}
