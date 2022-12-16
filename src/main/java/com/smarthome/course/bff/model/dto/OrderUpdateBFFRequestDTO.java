package com.smarthome.course.bff.model.dto;

import com.smarthome.course.entities.Payment;
import com.smarthome.course.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderUpdateBFFRequestDTO {
    private OrderStatus orderStatus;
    private Double inPartial;
    private Payment payment;
}
