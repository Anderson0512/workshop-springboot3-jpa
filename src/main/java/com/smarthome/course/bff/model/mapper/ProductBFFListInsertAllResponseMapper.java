package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.vo.ProductBFFVo;
import com.smarthome.course.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBFFListInsertAllResponseMapper {

    private final List<ProductBFFVo> responseDTO = new ArrayList<>();

    public ProductBFFListInsertAllResponseMapper(List<Product> productList) {

        for (Product product : productList) {
            ProductBFFVo bffVo = new ProductBFFVo();

            bffVo.setId(product.getId());
            bffVo.setName(product.getName());
            bffVo.setDescription(product.getDescription());
            bffVo.setPrice(product.getPrice());

            responseDTO.add(bffVo);
        }
    }

    public List<ProductBFFVo> toFrontend() {
        return responseDTO;
    }
}
