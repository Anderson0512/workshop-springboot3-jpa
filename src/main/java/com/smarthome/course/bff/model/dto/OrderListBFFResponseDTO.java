package com.smarthome.course.bff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderListBFFResponseDTO {
    @JsonProperty("_content")
    private List<OrderInsertBFFResponseDTO> content;
}
