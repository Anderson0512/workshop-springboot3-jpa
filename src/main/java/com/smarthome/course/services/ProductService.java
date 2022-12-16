package com.smarthome.course.services;

import com.smarthome.course.dto.AutenticationDTO;
import com.smarthome.course.entities.Product;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.exception.ResourceNotFoundException;
import com.smarthome.course.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Product> saveAll(List<Product> product) {
        return productRepository.saveAll(product);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> updateList(List<Product> product, List<Long> id) {

        try {

            List<Product> newList = new ArrayList<>();

            for (int i = 0; i < product.size(); i++) {
                Product product1 = productRepository.getReferenceById(id.get(i));
                product1.setName(product.get(i).getName());
                product1.setDescription(product.get(i).getDescription());
                product1.setPrice(product.get(i).getPrice());
                product1.setImgUrl(product.get(i).getImgUrl());
                newList.add(product1);
            }

            return productRepository.saveAll(newList);
        } catch (EntityNotFoundException e) {
            for (Long ident : id) {
                throw new ResourceNotFoundException(ident);
            }
            throw new BusinessException("Error in Id");
        }
    }

    public AutenticationDTO delete(List<Long> id) {
        try {
            AutenticationDTO auth = new AutenticationDTO();

            productRepository.deleteAllById(id);

            auth.setMoment(Instant.now());
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            auth.setKey(String.valueOf(algorithm.hashCode()));
            return auth;

        } catch (DataIntegrityViolationException | NoSuchAlgorithmException e) {
            throw new BusinessException(e.getMessage());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
