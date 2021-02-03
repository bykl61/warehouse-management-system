package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.convertor.ConvertTOProductDTO;
import org.fimba.warehousemanagmentsystem.dao.ProductCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.ProductOperationRepository;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.service.ProductOperationService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class ProductOperationServiceImpl implements ProductOperationService {
    private final ProductOperationRepository productOperationRepository;
    @Override

    public boolean isExist(String code) {
        if(productOperationRepository.findProductEntityByCode(code)==null){
            return false;
        }
        return true;
    }
}

