package org.fimba.warehousemanagmentsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class ProductWarehouseEntity {

    @JsonIgnore
    @EmbeddedId
    private ProductWarehouseId productWarehouseId = new ProductWarehouseId();


    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product")
    private ProductEntity productEntity;

    @ManyToOne
    @MapsId("warehouseId")
    @JoinColumn(name = "warehouse")
    private WarehouseEntity warehouseEntity;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user")
    private UserEntity userEntity;


    @Column(name = "stok")
    private Long stok;


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;





}
