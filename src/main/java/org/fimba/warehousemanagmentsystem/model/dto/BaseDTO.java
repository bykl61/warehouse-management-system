package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseDTO implements Serializable {
    private Long id;
    private String name;
    private String code;
    private Date createdDate;
    private Date updatedDate;
}
