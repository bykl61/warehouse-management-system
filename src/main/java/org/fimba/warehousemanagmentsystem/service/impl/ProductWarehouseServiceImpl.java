package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.dao.ProductCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.ProductWarehouseRepository;
import org.fimba.warehousemanagmentsystem.dao.UserCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
@Slf4j
@RequiredArgsConstructor
@Service
public class ProductWarehouseServiceImpl implements ProductWarehouseService {

    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final ProductCRUDRepository productCRUDRepository;
    private final ProductWarehouseRepository productWarehouseRepository;
    private final UserCRUDRepository userCRUDRepository;


    @Override
    public ResponseEntity<?> add(ProductWarehouseDTO dto) {
    // With the ID's taken from the user, we pull the objects from the database.
        WarehouseEntity warehouseEntity = warehouseCRUDRepository.findById(dto.getWarehouseId())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Warehouse"));

        ProductEntity productEntity = productCRUDRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Product"));

        UserEntity userEntity = userCRUDRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found User"));

        // We associate the objects with "ProductWarehouse".
        ProductWarehouseEntity productWarehouseEntity = new ProductWarehouseEntity();

        productWarehouseEntity.setStok(dto.getStok());
        productWarehouseEntity.setDate(new Date());

        productWarehouseEntity.setWarehouseEntity(warehouseEntity);
        productWarehouseEntity.setProductEntity(productEntity);
        productWarehouseEntity.setUserEntity(userEntity);

        productWarehouseRepository.save(productWarehouseEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> transfer(StockTransferDTO dto) {



        return null;
    }

    @Override
    public ResponseEntity<?> update(StockUpdateDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<?>> summaries() {
        Collection<ProductWarehouseEntity> productWarehouseEntity = productWarehouseRepository.findAllByWarehouseEntity();
        log.info(productWarehouseEntity.toString());
        return ResponseEntity.ok().body(productWarehouseEntity);
    }
}
