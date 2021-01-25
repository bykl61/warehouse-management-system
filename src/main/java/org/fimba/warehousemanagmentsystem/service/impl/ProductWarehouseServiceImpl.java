package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.dao.ProductWarehouseRepository;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ProductWarehouseServiceImpl implements ProductWarehouseService {
    private final ProductWarehouseRepository productWarehouseRepository;

        public ResponseEntity<ProductWarehouse> add(ProductWarehouse productWarehouse){
           return null;
        }
}
