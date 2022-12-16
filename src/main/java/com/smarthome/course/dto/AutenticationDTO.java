package com.smarthome.course.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AutenticationDTO {
    private Instant moment;
    private String key;
}
