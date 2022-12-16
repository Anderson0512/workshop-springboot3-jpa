package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.OrderInsertBFFResponseDTO;
import com.smarthome.course.bff.model.dto.OrderListBFFResponseDTO;
import com.smarthome.course.entities.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OrderListBFFResponseMapper {

    private final OrderListBFFResponseDTO responseDTO = new OrderListBFFResponseDTO();

    public OrderListBFFResponseMapper(List<Order> orders) {

        List<OrderInsertBFFResponseDTO> content = new ArrayList<>();

        for (Order order : orders){

            OrderInsertBFFResponseDTO responseList = new OrderInsertBFFResponseDTO();

            responseList.setId(order.getId());
            responseList.setMoment(order.getMoment());
            responseList.setOrderStatus(order.getOrderStatus());
            responseList.setInSignal(order.getSignal());
            responseList.setUser(order.getClient());

            if (order.getItems().isEmpty()) {
                responseList.setItems(new HashSet<>());
            } else {
                responseList.setItems(order.getItems());
            }

            responseList.setPayment(order.getPayment());
            responseList.setValueTotal(order.getTotal());
            responseList.setRestValueTotalToPay(order.getTotalFinal());

            content.add(responseList);
        }
        responseDTO.setContent(content);
    }

    public OrderListBFFResponseDTO toFrontend() {
        return responseDTO;
    }
}
