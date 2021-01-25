package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductWarehouseRepository extends JpaRepository<ProductWarehouse,Long> {
}
