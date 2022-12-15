package com.smarthome.course.services;

import com.smarthome.course.entities.User;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.exception.ResourceNotFoundException;
import com.smarthome.course.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void insert(User user) {
        userRepository.save(user);
    }

    public User update(User user, Long id) {
        try {
            User entityBd = userRepository.getReferenceById(id);

            updateData(user, entityBd);

            return userRepository.save(entityBd);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private static void updateData(User user, User entityBd) {
        entityBd.setName(user.getName());
        entityBd.setEmail(user.getEmail());
        entityBd.setPhone(user.getPhone());
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
