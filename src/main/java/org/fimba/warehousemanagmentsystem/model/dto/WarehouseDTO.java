package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.EntityStatus;

import java.io.Serializable;
@Getter
@Setter
public class WarehouseDTO implements Serializable {
    private EntityStatus entityStatus;
}
