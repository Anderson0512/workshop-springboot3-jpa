package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.ProductBFFDeleteResponseDTO;
import com.smarthome.course.dto.AutenticationDTO;

public class ProductBFFDeleteResponseMapper {

    ProductBFFDeleteResponseDTO responseDTO = new ProductBFFDeleteResponseDTO();

    public ProductBFFDeleteResponseMapper(AutenticationDTO responseBS) {
        responseDTO.setKey(responseBS.getKey());
        responseDTO.setHour(responseBS.getMoment());
        responseDTO.setDate(responseBS.getMoment());
    }
    public ProductBFFDeleteResponseDTO toFrontend(){
        return responseDTO;
    }
}
