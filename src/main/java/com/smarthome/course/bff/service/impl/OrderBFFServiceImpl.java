package com.smarthome.course.bff.service.impl;

import com.smarthome.course.bff.model.dto.OrderInsertBFFRequestDTO;
import com.smarthome.course.bff.model.dto.OrderInsertBFFResponseDTO;
import com.smarthome.course.bff.model.dto.OrderListBFFResponseDTO;
import com.smarthome.course.bff.model.mapper.OrderInsertBFFRequestMapper;
import com.smarthome.course.bff.model.mapper.OrderInsertBFFResponseMapper;
import com.smarthome.course.bff.model.mapper.OrderListBFFResponseMapper;
import com.smarthome.course.bff.service.OrderBFFService;
import com.smarthome.course.entities.Order;
import com.smarthome.course.entities.User;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.services.OrderService;
import com.smarthome.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBFFServiceImpl implements OrderBFFService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Override
    public OrderInsertBFFResponseDTO insert(OrderInsertBFFRequestDTO request) throws BusinessException {

        User user = userService.findById(request.getUserId());

        Order order = orderService.insert(new OrderInsertBFFRequestMapper(request,user).toBussiness());

        return new OrderInsertBFFResponseMapper(order).toFrontend();
    }

    @Override
    public OrderListBFFResponseDTO findAll() throws BusinessException {

        List<Order> orders = orderService.findAll();
        return new OrderListBFFResponseMapper(orders).toFrontend();
    }
}
