package org.fimba.WarehouseManagmentSystem.Model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

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

    @Column(nullable = false,length = 7)
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.ACTIVE;
}
