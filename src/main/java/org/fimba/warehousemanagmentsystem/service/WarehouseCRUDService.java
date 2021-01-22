package org.fimba.warehousemanagmentsystem.service;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseResponseEntity;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface WarehouseCRUDService extends WarehouseAPIBaseResponseEntity<WarehouseDTO> {

}
