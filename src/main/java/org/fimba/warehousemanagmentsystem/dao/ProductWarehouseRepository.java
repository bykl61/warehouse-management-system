package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductWarehouseRepository extends JpaRepository<ProductWarehouseEntity,Long> {
    @Query("select w from  ProductWarehouseEntity w where w.warehouseEntity.id=1")
    Collection<ProductWarehouseEntity>  findAllByWarehouseEntity();

}
