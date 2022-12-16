package com.smarthome.course.services;

import com.smarthome.course.dto.AutenticationDTO;
import com.smarthome.course.entities.Order;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.exception.ResourceNotFoundException;
import com.smarthome.course.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order, Long id) {

        try {
            Order entityBD = orderRepository.getReferenceById(id);
            entityBD.setOrderStatus(order.getOrderStatus());
            entityBD.setSignal(order.getSignal());
            entityBD.setPayment(order.getPayment());

            return orderRepository.save(entityBD);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public AutenticationDTO delete(Long id) {
        try {
            AutenticationDTO auth = new AutenticationDTO();

            orderRepository.deleteById(id);

            auth.setMoment(Instant.now());
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            auth.setKey(String.valueOf(algorithm.hashCode()));
            return auth;

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException | NoSuchAlgorithmException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
