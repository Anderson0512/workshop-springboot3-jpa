package com.smarthome.course.bff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smarthome.course.bff.model.vo.ProductBFFVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBFFResponseDTO {
    @JsonProperty("_content")
    private ProductBFFVo product;
}
