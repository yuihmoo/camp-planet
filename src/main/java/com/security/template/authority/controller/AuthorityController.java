package com.security.template.authority.controller;

import com.security.template.authority.dto.SignupRequest;
import com.security.template.user.entity.User;
import com.security.template.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorityController {
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody SignupRequest signupRequest) {
        signupRequest.setCreatedDate(LocalDateTime.now());
        return ResponseEntity.ok().body(userRepository.save(User.builder()
                .name(signupRequest.getName())
                .loginId(signupRequest.getLoginId())
                .password(signupRequest.getPassword())
                .role(signupRequest.getRole())
                .email(signupRequest.getEmail())
                .phone(signupRequest.getPhone())
                .createdDate(LocalDateTime.now())
                .build()));
    }
}
