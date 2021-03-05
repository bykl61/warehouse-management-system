package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductWarehouseId implements Serializable {

    @Column(name = "product_Id")
    private Long productId ;

    @Column(name = "warehouse_Id")
    private Long warehouseId ;

    @Column(name = "user_Id")
    private Long userId ;

}
