package com.smarthome.course.bff.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBFFRequestDTO {
    private String name;
    private String description;
    private Double price;
}
