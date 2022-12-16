package com.smarthome.course.bff.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBFFListUpdateVo {
    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private Double price;
}
