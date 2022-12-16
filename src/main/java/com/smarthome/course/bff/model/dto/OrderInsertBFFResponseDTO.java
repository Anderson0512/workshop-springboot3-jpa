package com.smarthome.course.bff.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthome.course.entities.OrderItem;
import com.smarthome.course.entities.Payment;
import com.smarthome.course.entities.User;
import com.smarthome.course.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OrderInsertBFFResponseDTO {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy 'T' HH:mm:ss 'Z'", timezone = "GMT-03:00")
    private Instant moment;
    private OrderStatus orderStatus;
    private Double inSignal;
    private User user;
    private Set<OrderItem> items = new HashSet<>();
    private Payment payment;
    private Double valueTotal;
    private Double restValueTotalToPay;
}
