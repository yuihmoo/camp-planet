package com.security.template.controller;

import com.security.template.dto.request.SignUpRequest;
import com.security.template.dto.request.LoginRequest;
import com.security.template.dto.response.AuthenticationResponse;
import com.security.template.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<AuthenticationResponse> logout(HttpServletRequest request) {
        authenticationService.logout(request);
        return ResponseEntity.ok().build();
    }
}
