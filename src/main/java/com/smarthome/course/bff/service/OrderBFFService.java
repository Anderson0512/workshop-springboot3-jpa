package com.smarthome.course.bff.service;

import com.smarthome.course.bff.model.dto.*;
import com.smarthome.course.exception.BusinessException;

public interface OrderBFFService {
    OrderInsertBFFResponseDTO insert(OrderInsertBFFRequestDTO request) throws BusinessException;

    OrderListBFFResponseDTO findAll() throws BusinessException;

    OrderInsertBFFResponseDTO update(OrderUpdateBFFRequestDTO request, Long id) throws BusinessException;

    AuthorizationBFFDeleteResponseDTO delete(Long id) throws BusinessException;
}
