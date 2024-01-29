package com.camp.planet.authentication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @NotBlank(message = "로그인 아이디는 필수 입니다.")
    @Size(min = 6, max = 12, message = "최소 6 ~ 12자 영문, 숫자 조합이여야 합니다.")
    private String loginId;

    //todo: 패턴 검증
    @NotBlank(message = "비밀번호는 필수 입니다.")
    private String password;

    @NotBlank(message = "이름은 필수 입니다.")
    @Size(min = 2, max = 20, message = "최소 2 ~ 20자의 이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "닉네임은 필수 입니다.")
    @Size(min = 2, max = 10, message = "최소 2 ~ 10자의 닉네임을 입력해주세요.")
    private String nickName;

    @NotEmpty(message = "차량 번호를 다시 확인해주세요.")
    @Size(min = 7, max = 10, message = "차량 번호는 최소 7자 이상입니다.")
    private String vehicleNumber;

    @NotEmpty(message = "지역을 다시 확인해주세요.")
    private String region;

    //todo: minio 구성 후 url 패턴 검증
    private String profile;

    @NotBlank(message = "이메일은 필수 입니다.")
    private String email;

    @NotBlank(message = "휴대폰 번호는 필수 입니다.")
    private String phone;
}
