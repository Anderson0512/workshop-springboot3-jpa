package com.smarthome.course.bff.controller;

import com.smarthome.course.bff.model.dto.OrderInsertBFFRequestDTO;
import com.smarthome.course.bff.model.dto.OrderInsertBFFResponseDTO;
import com.smarthome.course.bff.model.dto.OrderListBFFResponseDTO;
import com.smarthome.course.bff.service.OrderBFFService;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.resources.BaseControllerStandardResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderBFFController extends BaseControllerStandardResource {

    @Autowired
    private OrderBFFService orderBFFService;

    @GetMapping
    public OrderListBFFResponseDTO findAll() throws BusinessException {
        return orderBFFService.findAll();
    }

    @PostMapping
    public OrderInsertBFFResponseDTO insert(@RequestBody OrderInsertBFFRequestDTO request) throws BusinessException {
        return orderBFFService.insert(request);
    }
}
