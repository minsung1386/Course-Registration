package com.swcoach.courseregistration.domain.user;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 4, max = 25)
    @NotEmpty(message = "사용자 ID는 필수")
    private String username;

    @NotEmpty(message = "이름은 필수")
    private String name;

    @NotEmpty(message = "연락처는 필수")
    private String contact;

    @NotEmpty(message = "비밀번호는 필수")
    private String password;

    @NotEmpty(message = "비밀번호 확인 필수")
    private String password2;
}
