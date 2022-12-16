package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.OrderUpdateBFFRequestDTO;
import com.smarthome.course.entities.Order;

import java.time.Instant;

public class OrderUpdateBFFRequestMapper {
    private final Order order = new Order();

    public OrderUpdateBFFRequestMapper(OrderUpdateBFFRequestDTO request) {

        order.setOrderStatus(request.getOrderStatus());
        order.setSignal(request.getInPartial());
        order.getPayment().setMoment(Instant.now());
    }

    public Order toBusiness() {
        return order;
    }
}
