package com.smarthome.course.bff.model.vo;

import com.smarthome.course.entities.Order;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserBFFResponseVo implements Serializable {
    private static long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<Order> orders = new ArrayList<>();
}
