package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.dao.ProductCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.ProductWarehouseRepository;
import org.fimba.warehousemanagmentsystem.dao.UserCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/transfer")
public class ProductWarehouseController {

    private final ProductWarehouseService productWarehouseService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductWarehouseDTO dto) {
        return  productWarehouseService.add(dto);
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody StockUpdateDTO dto) {
        return  productWarehouseService.update(dto);
    }


    @GetMapping("/warehouses")
    public ResponseEntity<?> transfer(@RequestBody StockTransferDTO dto) {
        return productWarehouseService.transfer(dto);
    }

    @GetMapping
    public ResponseEntity<?> summaries() {
      return productWarehouseService.summaries();

    }

    @GetMapping("/list")
    public ResponseEntity<Collection<ProductWarehouseEntity>> list() {
        return productWarehouseService.list();

    }


}
