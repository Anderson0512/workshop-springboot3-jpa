package com.smarthome.course.services;

import com.smarthome.course.entities.User;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void insert(User user) {
        userRepository.save(user);
    }

    public void update(User user, Long id) {
        User entityBd = this.findById(id);

        if (entityBd.getId().equals(user.getId())){
            userRepository.save(user);
        }else {
            throw new BusinessException("Identifiers for change are divergent!");
        }
    }

    public void delete(Long id) {
        User entityBd = this.findById(id);

        if (Objects.nonNull(entityBd.getId())){
            userRepository.delete(entityBd);
        }else {
            throw new BusinessException("Identifiers of Identity not found!");
        }
    }
}
