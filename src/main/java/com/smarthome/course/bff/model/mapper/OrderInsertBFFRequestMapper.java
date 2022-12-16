package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.OrderInsertBFFRequestDTO;
import com.smarthome.course.entities.Order;
import com.smarthome.course.entities.User;
import com.smarthome.course.entities.enums.OrderStatus;

import java.time.Instant;

public class OrderInsertBFFRequestMapper {

    Order order = new Order();

    public OrderInsertBFFRequestMapper(OrderInsertBFFRequestDTO request, User user) {

        order.setMoment(Instant.now());
        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        order.setSignal(request.getInSignal());
        order.setClient(user);
    }

    public Order toBussiness() {
        return order;
    }
}
