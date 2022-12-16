package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.ProductBFFResponseDTO;
import com.smarthome.course.bff.model.vo.ProductBFFVo;
import com.smarthome.course.entities.Product;
import org.apache.commons.lang3.StringUtils;

public class ProductBFFResponseMapper {
    ProductBFFResponseDTO responseDTO = new ProductBFFResponseDTO();

    public ProductBFFResponseMapper(Product product){

        ProductBFFVo product1 = new ProductBFFVo();

        product1.setId(product.getId());
        product1.setName(StringUtils.trim(product.getName()));
        product1.setPrice(product.getPrice());
        product1.setDescription(StringUtils.trim(product.getDescription()));
        responseDTO.setProduct(product1);
    }
    public ProductBFFResponseDTO toFrontend(){
        return responseDTO;
    }
}
