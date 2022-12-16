package com.smarthome.course.bff.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInsertBFFResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
