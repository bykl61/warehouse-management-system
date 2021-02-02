package org.fimba.warehousemanagmentsystem.service;

import org.fimba.warehousemanagmentsystem.model.dto.ID;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;

import java.util.List;

public interface StockService {
    void update(StockUpdateDTO stockUpdateDTO);

    List<WarehouseEntity> list();
}
