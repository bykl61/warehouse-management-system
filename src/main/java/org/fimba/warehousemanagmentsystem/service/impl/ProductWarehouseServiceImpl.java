package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.dao.*;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.fimba.warehousemanagmentsystem.service.TransferOperationService;
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
    private final TransferOperationService transferOperationService;
    private final TransferOperationRepository transferOperationRepository;

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
        StockTransferDTO transferDTO = new StockTransferDTO();
        transferDTO.setToWarehouseId(dto.getToWarehouseId());
        transferDTO.setFromWarehouseId(dto.getFromWarehouseId());
        transferDTO.setProductId(dto.getProductId());

       boolean control = transferOperationService.isExist(transferDTO.getProductId(), transferDTO.getToWarehouseId());



       if(control){
            ProductWarehouseEntity warehouseEntity = transferOperationRepository.isExist(transferDTO.getProductId(), transferDTO.getToWarehouseId());
            Long stok = warehouseEntity.getStok();
            log.info("Stok Getirildi");
            productWarehouseRepository.delete(warehouseEntity);
            log.info("ProductWarehouse Silindi");

            ProductWarehouseEntity fromWarehouseEntity = transferOperationRepository.isExist(transferDTO.getProductId(),transferDTO.getFromWarehouseId());
            Long stok2 = fromWarehouseEntity.getStok();
            ProductWarehouseDTO productWarehouseDTO = new ProductWarehouseDTO();
            productWarehouseDTO.setProductId(transferDTO.getProductId());
            productWarehouseDTO.setWarehouseId(transferDTO.getToWarehouseId());
            productWarehouseDTO.setUserId(1L);
            productWarehouseDTO.setStok(stok + stok2);

            this.add(productWarehouseDTO);
            log.info("Yeni Kayıt Eklendi");
           return ResponseEntity.ok(HttpStatus.OK);
       }


        productWarehouseRepository.transfer(transferDTO.getToWarehouseId(),transferDTO.getFromWarehouseId(),transferDTO.getProductId());

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(StockUpdateDTO dto) {

        return null;
    }

    @Override
    public ResponseEntity<Collection<?>> summaries() {
        Collection<ProductWarehouseEntity> productWarehouseEntity = productWarehouseRepository.findAllByProductWarehouse();
        log.info(productWarehouseEntity.toString());
        return ResponseEntity.ok().body(productWarehouseEntity);
    }
}
