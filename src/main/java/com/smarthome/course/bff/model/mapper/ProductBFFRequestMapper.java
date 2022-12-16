package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.ProductBFFRequestDTO;
import com.smarthome.course.entities.Product;

public class ProductBFFRequestMapper {

    public final Product product = new Product();
    public ProductBFFRequestMapper(ProductBFFRequestDTO requestDTO) {

        product.setName(requestDTO.getName());
        product.setDescription(requestDTO.getDescription());
        product.setPrice(requestDTO.getPrice());
    }

    public Product getProduct() {
        return product;
    }
}
