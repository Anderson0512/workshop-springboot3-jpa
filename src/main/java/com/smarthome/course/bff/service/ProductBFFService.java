package com.smarthome.course.bff.service;

import com.smarthome.course.bff.model.dto.*;
import com.smarthome.course.bff.model.vo.ProductBFFVo;
import com.smarthome.course.exception.BusinessException;

import java.util.List;

public interface ProductBFFService {
    ProductBFFResponseDTO product(ProductBFFRequestDTO request) throws BusinessException;

    ProductBFFListResponseDTO listProduct() throws BusinessException;

    List<ProductBFFVo> insertList(List<ProductBFFListRequestDTO> request) throws BusinessException;

    List<ProductBFFVo> updateList(List<ProductBFFListUpdateRequestDTO> request) throws BusinessException;

    AuthorizationBFFDeleteResponseDTO delete(List<ProductBFFDeleteRequestDTO> request) throws BusinessException;
}
