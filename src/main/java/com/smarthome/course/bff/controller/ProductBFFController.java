package com.smarthome.course.bff.controller;

import com.smarthome.course.bff.model.dto.*;
import com.smarthome.course.bff.model.vo.ProductBFFVo;
import com.smarthome.course.bff.service.ProductBFFService;
import com.smarthome.course.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductBFFController {

    @Autowired
    private ProductBFFService productBFFService;

    @PostMapping
    public ProductBFFResponseDTO insert(@RequestBody ProductBFFRequestDTO request) throws BusinessException {
        return productBFFService.product(request);
    }

    @GetMapping
    public ProductBFFListResponseDTO findAll() throws BusinessException {
        return productBFFService.listProduct();
    }

    @PostMapping("/list")
    public List<ProductBFFVo> insertList(@RequestBody List<ProductBFFListRequestDTO> request) throws BusinessException {
        return productBFFService.insertList(request);
    }

    @PutMapping("/list")
    public List<ProductBFFVo> updateList(@RequestBody List<ProductBFFListUpdateRequestDTO> request) throws BusinessException {
        return productBFFService.updateList(request);
    }

    @DeleteMapping("/delete")
    public AuthorizationBFFDeleteResponseDTO delete(@RequestBody List<ProductBFFDeleteRequestDTO> request) throws BusinessException {
        return productBFFService.delete(request);
    }
}
