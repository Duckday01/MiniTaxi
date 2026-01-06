package com.duclm.minitaxi.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {

    private Boolean enabled;

    @Email
    private String email;

    private Integer phone;

    private String address;
}
