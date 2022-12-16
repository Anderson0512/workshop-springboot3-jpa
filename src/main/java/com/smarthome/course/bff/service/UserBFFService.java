package com.smarthome.course.bff.service;

import com.smarthome.course.bff.model.dto.AuthorizationBFFDeleteResponseDTO;
import com.smarthome.course.bff.model.dto.UserBFFRequestDTO;
import com.smarthome.course.bff.model.dto.UserBFFResponseDTO;
import com.smarthome.course.bff.model.dto.UserInsertBFFResponseDTO;
import com.smarthome.course.exception.BusinessException;

public interface UserBFFService {
    UserBFFResponseDTO getUsers() throws BusinessException;

    UserInsertBFFResponseDTO insertUser(UserBFFRequestDTO request) throws BusinessException;

    UserInsertBFFResponseDTO updateUser(UserBFFRequestDTO request, Long id) throws BusinessException;

    UserInsertBFFResponseDTO findById(Long id) throws BusinessException;

    AuthorizationBFFDeleteResponseDTO delete(Long id) throws BusinessException;
}
