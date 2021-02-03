package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class WarehouseEntity extends BaseEntity{



   /*@ElementCollection
    @CollectionTable(
            name= "PRODUCT_WAREHOUSE",
            joinColumns = @JoinColumn(name = "WAREHOUSE_ID")
    )
    private Set<ProductWarehouse> productWarehouses = new HashSet<>();*/



    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",length = 7,nullable = false)
    private WarehouseStatus status = WarehouseStatus.ACTIVE;

}
