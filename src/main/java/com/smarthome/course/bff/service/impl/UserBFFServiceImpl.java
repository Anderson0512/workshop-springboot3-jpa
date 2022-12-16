package com.smarthome.course.bff.service.impl;

import com.smarthome.course.bff.model.dto.AuthorizationBFFDeleteResponseDTO;
import com.smarthome.course.bff.model.dto.UserBFFRequestDTO;
import com.smarthome.course.bff.model.dto.UserBFFResponseDTO;
import com.smarthome.course.bff.model.dto.UserInsertBFFResponseDTO;
import com.smarthome.course.bff.model.mapper.BaseBFFDeleteResponseMapper;
import com.smarthome.course.bff.model.mapper.UserBFFRequestMapper;
import com.smarthome.course.bff.model.mapper.UserBFFResponseMapper;
import com.smarthome.course.bff.model.mapper.UserInsertBFFResponseMapper;
import com.smarthome.course.bff.service.UserBFFService;
import com.smarthome.course.dto.AutenticationDTO;
import com.smarthome.course.entities.User;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBFFServiceImpl implements UserBFFService {

    @Autowired
    private UserService userService;

    @Override
    public UserBFFResponseDTO getUsers() throws BusinessException {

        List<User> userList = userService.findAll();

        return new UserBFFResponseMapper(userList).toFrontend();
    }

    @Override
    public UserInsertBFFResponseDTO insertUser(UserBFFRequestDTO request) throws BusinessException {

        User user = userService.insert(new UserBFFRequestMapper(request).getUser());

        return new UserInsertBFFResponseMapper(user).toFrontend();
    }

    @Override
    public UserInsertBFFResponseDTO updateUser(UserBFFRequestDTO request, Long id) throws BusinessException {

        User user = userService.update(new UserBFFRequestMapper(request).getUser(), id);

        return new UserInsertBFFResponseMapper(user).toFrontend();
    }

    @Override
    public UserInsertBFFResponseDTO findById(Long id) throws BusinessException {
        User user = userService.findById(id);

        return new UserInsertBFFResponseMapper(user).toFrontend();
    }

    @Override
    public AuthorizationBFFDeleteResponseDTO delete(Long id) throws BusinessException {

        AutenticationDTO auth = userService.delete(id);

        return new BaseBFFDeleteResponseMapper(auth).toFrontend();
    }
}
