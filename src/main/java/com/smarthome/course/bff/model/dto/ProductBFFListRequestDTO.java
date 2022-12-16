package com.smarthome.course.bff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smarthome.course.bff.model.vo.ProductBFFListVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBFFListRequestDTO {
    @JsonProperty("_data")
    private ProductBFFListVo listVo;
}
