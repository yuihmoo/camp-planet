package com.security.template.service.impl;

import com.security.template.constant.Role;
import com.security.template.dto.request.LoginRequest;
import com.security.template.dto.request.SignUpRequest;
import com.security.template.dto.response.AuthenticationResponse;
import com.security.template.entity.User;
import com.security.template.repository.UserRepository;
import com.security.template.service.AuthenticationService;
import com.security.template.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.lang.NonNull;
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
    private final RedisTemplate<String, String> redisTemplate;

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
        AuthenticationResponse authenticationResponse = jwtService.generateAuthenticationResponse(user);
        this.saveRefreshTokenHistory(user.getLoginId(), authenticationResponse.getRefreshToken());
        return authenticationResponse;
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword()));
        var user = userRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호를 다시 확인해주세요."));
        AuthenticationResponse authenticationResponse = jwtService.generateAuthenticationResponse(user);
        this.saveRefreshTokenHistory(user.getLoginId(), authenticationResponse.getRefreshToken());
        return authenticationResponse;
    }

    @Override
    public void logout(@NonNull HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String accessToken = authHeader.substring(7);
        String loginId = jwtService.extractUserName(accessToken);
        this.deleteRefreshTokenHistory(loginId);
    }

    @Override
    public void saveRefreshTokenHistory(String loginId, String refreshToken) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(loginId, refreshToken);
    }

    @Override
    public void deleteRefreshTokenHistory(String loginId) {
        redisTemplate.delete(loginId);
    }
}
