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
    @JoinColumn(name = "products")
    private ProductEntity productEntity;

    @ManyToOne
    @MapsId("warehouseId")
    @JoinColumn(name = "warehouses")
    private WarehouseEntity warehouseEntity;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "users")
    private UserEntity userEntity;


    @Column(name = "stoks")
    private Long stok;


    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "dates")
    private Date date;





}
