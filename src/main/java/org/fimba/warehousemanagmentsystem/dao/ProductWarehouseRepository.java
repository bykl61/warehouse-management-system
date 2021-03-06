package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductWarehouseRepository extends JpaRepository<ProductWarehouseEntity,Long> {
    @Query("select w from  ProductWarehouseEntity w ")
    Collection<ProductWarehouseEntity>  findAllByProductWarehouse();

    @Transactional
    @Modifying
    @Query("update ProductWarehouseEntity  set warehouseEntity.id = :toWarehouseId where warehouseEntity.id = :fromWarehouseId " +
            "and productEntity.id = :productId")
    void transfer(@Param("toWarehouseId") Long toWarehouseId, @Param("fromWarehouseId") Long fromWarehouseId, @Param("productId") Long productId);



}
