package org.fimba.warehousemanagmentsystem.convertor;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.stereotype.Component;

@Component
public class ConvertToWarehouseEntity implements WarehouseAPIBaseConvetor<WarehouseDTO, WarehouseEntity> {

    @Override
    public WarehouseEntity convertor(WarehouseDTO convert) {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setId(convert.getId());
        warehouseEntity.setName(convert.getName());
        warehouseEntity.setCode(convert.getCode());
        warehouseEntity.setCreatedDate(convert.getCreatedDate());
        warehouseEntity.setUpdatedDate(convert.getUpdatedDate());
        warehouseEntity.setWarehouseStatus(convert.getStatus());
        return warehouseEntity;
    }


}
