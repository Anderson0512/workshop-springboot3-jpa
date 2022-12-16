package com.smarthome.course.bff.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBFFRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
}
