package com.smarthome.course.bff.controller;

import com.smarthome.course.bff.model.dto.AuthorizationBFFDeleteResponseDTO;
import com.smarthome.course.bff.model.dto.UserBFFRequestDTO;
import com.smarthome.course.bff.model.dto.UserBFFResponseDTO;
import com.smarthome.course.bff.model.dto.UserInsertBFFResponseDTO;
import com.smarthome.course.bff.service.UserBFFService;
import com.smarthome.course.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserBFFController {

    @Autowired
    private UserBFFService userBFFService;

    @GetMapping
    public UserBFFResponseDTO getUsersList() throws BusinessException {
        return userBFFService.getUsers();
    }

    @PostMapping
    UserInsertBFFResponseDTO insertUser(@RequestBody UserBFFRequestDTO request) throws BusinessException {
        return userBFFService.insertUser(request);
    }

    @GetMapping("/{id}")
    public UserInsertBFFResponseDTO findBy(@PathVariable Long id) throws BusinessException {
        return userBFFService.findById(id);
    }

    @PutMapping("/{id}")
    public UserInsertBFFResponseDTO updateUser(@RequestBody UserBFFRequestDTO request, @PathVariable Long id)
            throws BusinessException {
        return userBFFService.updateUser(request, id);
    }

    @DeleteMapping("/{id}")
    AuthorizationBFFDeleteResponseDTO delete(@PathVariable Long id) throws BusinessException {
        return userBFFService.delete(id);
    }
}
