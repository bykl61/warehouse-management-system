package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.dao.ProductCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.UserCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ID;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.*;
import org.fimba.warehousemanagmentsystem.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {

    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final ProductCRUDRepository productCRUDRepository;
    private final UserCRUDRepository userCRUDRepository;
    private final EntityManager em;


    @Override
    @Transactional
    public void update(StockUpdateDTO stockUpdateDTO) {
        WarehouseEntity warehouseEntity = warehouseCRUDRepository.findById(stockUpdateDTO.getWarehouseID())
                .orElseThrow(() -> new ResourceNotFoundException("Not found warehouseEntity"));

        em.createNativeQuery("insert into product_warehouse values(?,?,?) ")
                .setParameter(1,stockUpdateDTO.getWarehouseID())
                .setParameter(2,stockUpdateDTO.getProductID())
                .setParameter(3,stockUpdateDTO.getUserID())
                .executeUpdate();


       /* ProductEntity product = productCRUDRepository.findById(stockUpdateDTO.getProductID())
                .orElseThrow(() -> new ResourceNotFoundException("Not found product"));


        UserEntity userEntity = userCRUDRepository.findById(stockUpdateDTO.getUserID())
                .orElseThrow(() -> new ResourceNotFoundException("Not found user"));


        ProductWarehouse productWarehouse = new ProductWarehouse(product,userEntity);

        warehouseEntity.getProductWarehouses().add(productWarehouse);*/

    }

    @Override
    public List<WarehouseEntity> list() {



      List<WarehouseEntity> warehouseEntities = em.createQuery(
               "select w from WarehouseEntity w "+
               "join w.productWarehouses wp ")
               .getResultList();
        return warehouseEntities;

    }
}
