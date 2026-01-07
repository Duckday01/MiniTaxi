package com.duclm.minitaxi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    @NotEmpty(message = "Xin vui lòng nhập tên đăng nhập")
    private String username;
    @NotEmpty(message = "Xin vui lòng nhập mật khẩu")
    private String password;
}
