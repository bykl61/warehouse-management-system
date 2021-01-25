package org.fimba.warehousemanagmentsystem.model.dto;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

public class ProductWarehouseDTO  {

  private Long stockAmount;
}
