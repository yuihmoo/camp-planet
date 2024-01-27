package com.security.template.user.service;

import com.security.template.authority.dto.SignupRequest;
import com.security.template.user.entity.User;
import com.security.template.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User signup(SignupRequest signupRequest) {
        User user = User.builder()
                .name(signupRequest.getName())
                .loginId(signupRequest.getLoginId())
                .password(signupRequest.getPassword())
                .role(signupRequest.getRole())
                .email(signupRequest.getEmail())
                .phone(signupRequest.getPhone())
                .createdDate(LocalDateTime.now())
                .build();

        return userRepository.save(user);
    }
}
