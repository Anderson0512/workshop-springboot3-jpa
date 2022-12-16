package com.smarthome.course.bff.model.dto;

import com.smarthome.course.entities.User;
import com.smarthome.course.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInsertBFFRequestDTO {
    private Long userId;
    private OrderStatus orderStatus;
    private Double inSignal;
    private User user;
}
