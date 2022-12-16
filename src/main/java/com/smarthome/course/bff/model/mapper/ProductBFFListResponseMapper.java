package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.ProductBFFListResponseDTO;
import com.smarthome.course.bff.model.vo.ProductBFFVo;
import com.smarthome.course.entities.Product;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductBFFListResponseMapper {

    private final ProductBFFListResponseDTO responseDTO = new ProductBFFListResponseDTO();

    public ProductBFFListResponseMapper(List<Product> productList) {

        List<ProductBFFVo> content = new ArrayList<>();

        for (Product product : productList) {
            ProductBFFVo bffVo = new ProductBFFVo();

            bffVo.setId(product.getId());
            bffVo.setName(product.getName());
            bffVo.setDescription(product.getDescription());
            bffVo.setPrice(product.getPrice());

            content.add(bffVo);
        }
        responseDTO.setContent(content);
    }

    public ProductBFFListResponseDTO toFrontend() {
        return responseDTO;
    }
}
