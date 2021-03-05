package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Data;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;
@Data
public class ProductWarehouseDTO  {

  private Long productId;

  private Long warehouseId;

  private Long userId;

  private Long stok;

  private Date date;
}
