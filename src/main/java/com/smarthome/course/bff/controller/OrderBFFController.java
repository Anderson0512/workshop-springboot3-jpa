package com.smarthome.course.bff.controller;

import com.smarthome.course.bff.model.dto.*;
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

    @PutMapping("/{id}")
    public OrderInsertBFFResponseDTO update(OrderUpdateBFFRequestDTO request, Long id) throws BusinessException{
        return orderBFFService.update(request, id);
    }

    @DeleteMapping("/{id}")
    AuthorizationBFFDeleteResponseDTO delete(@PathVariable Long id) throws BusinessException {
        return orderBFFService.delete(id);
    }
}
