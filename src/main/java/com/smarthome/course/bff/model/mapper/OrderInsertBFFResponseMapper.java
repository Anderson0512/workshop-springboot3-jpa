package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.OrderInsertBFFResponseDTO;
import com.smarthome.course.entities.Order;

import java.util.HashSet;

public class OrderInsertBFFResponseMapper {

    private final OrderInsertBFFResponseDTO responseDTO = new OrderInsertBFFResponseDTO();

    public OrderInsertBFFResponseMapper(Order order) {
        responseDTO.setId(order.getId());
        responseDTO.setMoment(order.getMoment());
        responseDTO.setOrderStatus(order.getOrderStatus());
        responseDTO.setInSignal(order.getSignal());
        responseDTO.setUser(order.getClient());

        if (order.getItems().isEmpty()) {
            responseDTO.setItems(new HashSet<>());
        } else {
            responseDTO.setItems(order.getItems());
        }
        responseDTO.setPayment(order.getPayment());
        responseDTO.setValueTotal(order.getTotal());
        responseDTO.setRestValueTotalToPay(order.getTotalFinal());
    }

    public OrderInsertBFFResponseDTO toFrontend() {
        return responseDTO;
    }
}
