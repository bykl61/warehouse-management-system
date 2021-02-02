package org.fimba.warehousemanagmentsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductWarehouse {
    /*@EmbeddedId
    ProductWarehouseId productWarehouseId = new ProductWarehouseId();
    */
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    ProductEntity product ;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    UserEntity user ;

   /* @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    UserEntity userEntity;*/

   /* @Column(name = "stockAmount")
    private Long stockAmount;*/

    @Column(name = "transctionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate = new Date();

    public ProductWarehouse(ProductEntity product, UserEntity user) {
        this.product = product;
        this.user = user;
    }
}
