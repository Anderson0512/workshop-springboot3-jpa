package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.UserInsertBFFResponseDTO;
import com.smarthome.course.entities.User;

public class UserInsertBFFResponseMapper {

    private final UserInsertBFFResponseDTO responseDTO = new UserInsertBFFResponseDTO();

    public UserInsertBFFResponseMapper(User user) {

        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setPhone(user.getPhone());
        responseDTO.setPassword(user.getPassword());
    }

    public UserInsertBFFResponseDTO toFrontend() {
        return responseDTO;
    }
}
