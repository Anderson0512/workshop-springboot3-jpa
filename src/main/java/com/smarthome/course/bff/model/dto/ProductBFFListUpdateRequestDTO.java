package com.smarthome.course.bff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smarthome.course.bff.model.vo.ProductBFFListUpdateVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBFFListUpdateRequestDTO {
    @JsonProperty("_data")
    private ProductBFFListUpdateVo listVo;
}
