package com.smarthome.course.bff.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ProductBFFDeleteResponseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss",timezone = "GMT-03:00")
    private Instant hour;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",timezone = "GMT-03:00")
    private Instant date;
    private String key;
}
