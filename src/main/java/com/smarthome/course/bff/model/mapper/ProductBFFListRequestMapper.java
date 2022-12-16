package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.ProductBFFListRequestDTO;
import com.smarthome.course.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBFFListRequestMapper {

    public final List<Product> productList = new ArrayList<>();

    public ProductBFFListRequestMapper(List<ProductBFFListRequestDTO> requestDTO) {

        for (ProductBFFListRequestDTO productBFFListRequestDTO : requestDTO) {

            Product product = new Product();

            product.setName(productBFFListRequestDTO.getListVo().getName());
            product.setDescription(productBFFListRequestDTO.getListVo().getDescription());
            product.setPrice(productBFFListRequestDTO.getListVo().getPrice());
            productList.add(product);
        }
    }

    public List<Product> getProduct() {
        return productList;
    }
}
