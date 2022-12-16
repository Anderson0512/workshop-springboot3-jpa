package com.smarthome.course.bff.service;

import com.smarthome.course.bff.model.dto.OrderInsertBFFRequestDTO;
import com.smarthome.course.bff.model.dto.OrderInsertBFFResponseDTO;
import com.smarthome.course.bff.model.dto.OrderListBFFResponseDTO;
import com.smarthome.course.exception.BusinessException;

public interface OrderBFFService {
    OrderInsertBFFResponseDTO insert(OrderInsertBFFRequestDTO request) throws BusinessException;

    OrderListBFFResponseDTO findAll() throws BusinessException;
}
