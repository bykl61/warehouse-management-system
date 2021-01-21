package org.fimba.warehousemanagmentsystem.model.entities;

import org.fimba.warehousemanagmentsystem.model.enums.EntityStatus;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntity{

    @Column(name = "EMAİL",unique = true,length = 20,nullable = false)
    private String email;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @Column(name = "STATUS",length = 7)
    @Enumerated(EnumType.STRING)
    private EntityStatus entityStatus = EntityStatus.ACTIVE;
}
