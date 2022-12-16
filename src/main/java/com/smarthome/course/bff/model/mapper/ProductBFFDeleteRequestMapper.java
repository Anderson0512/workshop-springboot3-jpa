package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.ProductBFFDeleteRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductBFFDeleteRequestMapper {

    List<Long> ids = new ArrayList<>();
    public ProductBFFDeleteRequestMapper(List<ProductBFFDeleteRequestDTO> request){

        for (ProductBFFDeleteRequestDTO requestDTO : request){
            ids.add(requestDTO.getId());
        }
    }

    public List<Long> getIds() {
        return ids;
    }
}
