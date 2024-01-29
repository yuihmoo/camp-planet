package com.camp.planet.authentication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "로그인 아이디는 필수 입니다.")
    @Size(min = 6, max = 12, message = "최소 6 ~ 12자 영문, 숫자 조합이여야 합니다.")
    private String loginId;

    //todo: 패턴 검증
    @NotBlank(message = "비밀번호는 필수 입니다.")
    private String password;
}
