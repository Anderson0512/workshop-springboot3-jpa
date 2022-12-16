package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.UserBFFRequestDTO;
import com.smarthome.course.entities.User;

public class UserBFFRequestMapper {

    private final User user = new User();

    public UserBFFRequestMapper(UserBFFRequestDTO request){

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
    }

    public User getUser() {
        return user;
    }
}
