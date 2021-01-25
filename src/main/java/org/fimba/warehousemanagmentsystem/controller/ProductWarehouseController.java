package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
@RequiredArgsConstructor
@Controller
public class ProductWarehouseController {

    private final ProductWarehouseService productWarehouseService;
    public ResponseEntity<ProductWarehouse> add(@RequestBody ProductWarehouse productWarehouse){

           return null;
    }
}
