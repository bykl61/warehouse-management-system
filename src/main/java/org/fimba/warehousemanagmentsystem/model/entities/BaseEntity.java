package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(nullable = false,length = 7)
    @Enumerated(value = EnumType.STRING)
    private WarehouseStatus warehouseStatus = WarehouseStatus.ACTIVE;
}
