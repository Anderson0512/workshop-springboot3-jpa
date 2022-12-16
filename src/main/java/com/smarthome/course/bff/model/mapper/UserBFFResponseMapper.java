package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.UserBFFResponseDTO;
import com.smarthome.course.bff.model.vo.UserBFFResponseVo;
import com.smarthome.course.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserBFFResponseMapper {

    private final UserBFFResponseDTO responseDTO = new UserBFFResponseDTO();

    public UserBFFResponseMapper(List<User> users) {

        List<UserBFFResponseVo> content = new ArrayList<>();

        for (User user : users) {
            UserBFFResponseVo userVo = new UserBFFResponseVo();

            userVo.setId(user.getId());
            userVo.setName(user.getName());
            userVo.setEmail(user.getEmail());
            userVo.setPhone(user.getPhone());
            userVo.setPassword(user.getPassword());
            if (user.getOrders().isEmpty()) {
                userVo.getOrders().addAll(new ArrayList<>());
            } else {
                userVo.getOrders().addAll(user.getOrders());
            }
            content.add(userVo);
        }
        responseDTO.setContent(content);
    }

    public UserBFFResponseDTO toFrontend() {
        return responseDTO;
    }
}
