package com.smarthome.course.bff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smarthome.course.bff.model.vo.UserBFFResponseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBFFResponseDTO {
    @JsonProperty("_content")
    private List<UserBFFResponseVo> content;
}
