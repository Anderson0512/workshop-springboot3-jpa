package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.ProductBFFListUpdateRequestDTO;
import com.smarthome.course.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBFFListUpdateRequestMapper {

    public final List<Product> productList = new ArrayList<>();

    public ProductBFFListUpdateRequestMapper(List<ProductBFFListUpdateRequestDTO> requestDTO) {

        for (ProductBFFListUpdateRequestDTO productBFFListRequestDTO : requestDTO) {

            Product product = new Product();

            product.setName(productBFFListRequestDTO.getListVo().getName());
            product.setDescription(productBFFListRequestDTO.getListVo().getDescription());
            product.setPrice(productBFFListRequestDTO.getListVo().getPrice());
            product.setImgUrl(productBFFListRequestDTO.getListVo().getImgUrl());
            productList.add(product);
        }
    }
    public List<Product> getProduct() {
        return productList;
    }
}
