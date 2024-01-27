package com.security.template.authority.dto;

import com.security.template.authority.type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String loginId;
    private String password;
    private String name;
    private RoleType role;
    private String email;
    private String phone;
    private LocalDateTime createdDate;
}
