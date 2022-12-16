package com.smarthome.course.bff.service.impl;

import com.smarthome.course.bff.model.dto.*;
import com.smarthome.course.bff.model.mapper.*;
import com.smarthome.course.bff.model.vo.ProductBFFVo;
import com.smarthome.course.bff.service.ProductBFFService;
import com.smarthome.course.dto.AutenticationDTO;
import com.smarthome.course.entities.Product;
import com.smarthome.course.exception.BusinessException;
import com.smarthome.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBFFServiceImpl implements ProductBFFService {

    @Autowired
    private ProductService productService;

    @Override
    public ProductBFFResponseDTO product(ProductBFFRequestDTO request) throws BusinessException {

        Product product = productService.save(new ProductBFFRequestMapper(request).getProduct());
        return new ProductBFFResponseMapper(product).toFrontend();
    }

    @Override
    public ProductBFFListResponseDTO listProduct() throws BusinessException {

        List<Product> productList = productService.findAll();

        return new ProductBFFListResponseMapper(productList).toFrontend();
    }

    @Override
    public List<ProductBFFVo> insertList(List<ProductBFFListRequestDTO> request) throws BusinessException {

        List<Product> productList = productService.saveAll(new ProductBFFListRequestMapper(request).getProduct());
        return new ProductBFFListInsertAllResponseMapper(productList).toFrontend();
    }

    @Override
    public List<ProductBFFVo> updateList(List<ProductBFFListUpdateRequestDTO> request) throws BusinessException {
        List<Long> ids = new ArrayList<>();

        for (ProductBFFListUpdateRequestDTO productBFFListUpdateRequestDTO : request) {
            ids.add(productBFFListUpdateRequestDTO.getListVo().getId());
        }

        List<Product> productList = productService.updateList(new ProductBFFListUpdateRequestMapper(request).productList, ids);

        return new ProductBFFListInsertAllResponseMapper(productList).toFrontend();
    }

    @Override
    public AuthorizationBFFDeleteResponseDTO delete(List<ProductBFFDeleteRequestDTO> request) throws BusinessException {

        AutenticationDTO auth = productService.delete(new ProductBFFDeleteRequestMapper(request).getIds());

        return new BaseBFFDeleteResponseMapper(auth).toFrontend();
    }
}
