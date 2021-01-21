package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.EntityStatus;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class WarehouseEntity extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS",length = 7,nullable = false)
    private EntityStatus entityStatus = EntityStatus.ACTIVE;
}
