package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ProductWarehouseDTO  {

  private Long productId;

  private Long warehouseId;

  private Long userId;

  private Long stok;

  private Date date;
}
