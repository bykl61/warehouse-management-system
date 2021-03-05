package org.fimba.warehousemanagmentsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.UserStatus;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class UserEntity extends BaseEntity{


    @Column(name = "EMAIL")
    private String email;


    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS",length = 7)
    @Enumerated(value=EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    @JsonIgnore
    @OneToMany(mappedBy = "userEntity")
    Set<ProductWarehouseEntity> warehouseEntities;

}
