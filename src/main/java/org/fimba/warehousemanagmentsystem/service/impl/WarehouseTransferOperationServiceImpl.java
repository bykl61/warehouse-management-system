package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.dao.ProductWarehouseRepository;
import org.fimba.warehousemanagmentsystem.dao.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.WarehouseTransferOperationRepository;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseTransferDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.fimba.warehousemanagmentsystem.service.WarehouseTransferOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class WarehouseTransferOperationServiceImpl implements WarehouseTransferOperationService {
    private final ProductWarehouseRepository productWarehouseRepository;
    private final WarehouseTransferOperationRepository transferOperationRepository;
    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final EntityManager entityManager;

    @Transactional
    @Override
    public WarehouseAPIResponseHolder<?> transfer(WarehouseTransferDTO dto) {

        ArrayList<ProductWarehouseEntity> fromProductWarehouses = (ArrayList<ProductWarehouseEntity>) transferOperationRepository
                .getProductsByFromWarehouseId(dto.getFromWarehouseId());

        ArrayList<ProductWarehouseEntity> toProductWarehouses = (ArrayList<ProductWarehouseEntity>) transferOperationRepository
                .getProductsByToWarehouseId(dto.getToWarehouseId());

        if (fromProductWarehouses == null) {
            return new WarehouseAPIResponseHolder<>(HttpStatus.BAD_REQUEST);
        }

        if (toProductWarehouses != null) {

            for (ProductWarehouseEntity from : fromProductWarehouses) {
                boolean isExist = true;
                for (ProductWarehouseEntity to : toProductWarehouses) {
                    if (from.getProductEntity().getId() == to.getProductEntity().getId()) {
                        log.info("ilk döngüye girildi");
                        to.setStok(to.getStok() + from.getStok());
                      //  productWarehouseRepository.delete(from);
                        productWarehouseRepository.saveAll(toProductWarehouses);
                        isExist = false;
                        log.info(String.valueOf(isExist));
                    }
                }

                if (isExist) {
                for (ProductWarehouseEntity to : toProductWarehouses) {

                        log.info(String.valueOf(isExist));
                        log.info("craete productwarehouse");
                        ProductWarehouseEntity productWarehouseEntity = new ProductWarehouseEntity();
                        productWarehouseEntity.setProductEntity(from.getProductEntity());
                        productWarehouseEntity.setWarehouseEntity(to.getWarehouseEntity());
                        productWarehouseEntity.setUserEntity(from.getUserEntity());
                        productWarehouseEntity.setStok(from.getStok());
                        productWarehouseEntity.setDate(from.getDate());
                        log.info("craeted productwarehouse");

                        log.info("Starting delete from");
                      //  productWarehouseRepository.delete(from);
                        log.info("Started delete from");

                        log.info("Starting save producwarehouse");
                        productWarehouseRepository.save(productWarehouseEntity);
                        log.info("Saved to productWarehouse");
                    }
                }


            }
        }/*else{
            for (ProductWarehouseEntity from : fromProductWarehouses){
                from.setWarehouseEntity(warehouseCRUDRepository.getOne(dto.getToWarehouseId()));
                productWarehouseRepository.save(from);
            }
        }*/
         productWarehouseRepository.deleteAll(fromProductWarehouses);
        log.info("Döngüden çıkıldı");


        return new WarehouseAPIResponseHolder<>(HttpStatus.OK);
    }



}
