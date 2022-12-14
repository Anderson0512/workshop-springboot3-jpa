package com.smarthome.course.bff.model.mapper;

import com.smarthome.course.bff.model.dto.AuthorizationBFFDeleteResponseDTO;
import com.smarthome.course.dto.AutenticationDTO;

public class BaseBFFDeleteResponseMapper {

    AuthorizationBFFDeleteResponseDTO responseDTO = new AuthorizationBFFDeleteResponseDTO();

    public BaseBFFDeleteResponseMapper(AutenticationDTO responseBS) {
        responseDTO.setKey(responseBS.getKey());
        responseDTO.setHour(responseBS.getMoment());
        responseDTO.setDate(responseBS.getMoment());
    }
    public AuthorizationBFFDeleteResponseDTO toFrontend(){
        return responseDTO;
    }
}
