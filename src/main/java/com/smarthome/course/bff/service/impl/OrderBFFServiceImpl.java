package com.smarthome.course.bff.service.impl;

import com.smarthome.course.bff.model.dto.*;
import com.smarthome.course.bff.model.mapper.*;
import com.smarthome.course.bff.service.OrderBFFService;
import com.smarthome.course.dto.AutenticationDTO;
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

    @Override
    public OrderInsertBFFResponseDTO update(OrderUpdateBFFRequestDTO request, Long id) throws BusinessException {

        Order order = orderService.update(new OrderUpdateBFFRequestMapper(request).toBusiness(),id);

        return new OrderInsertBFFResponseMapper(order).toFrontend();
    }

    @Override
    public AuthorizationBFFDeleteResponseDTO delete(Long id) throws BusinessException {

        AutenticationDTO auth = orderService.delete(id);

        return new BaseBFFDeleteResponseMapper(auth).toFrontend();
    }
}
