package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class StockUpdateDTO {

    private Long productID;
    private Long warehouseID;
    private Long UserID;

}
