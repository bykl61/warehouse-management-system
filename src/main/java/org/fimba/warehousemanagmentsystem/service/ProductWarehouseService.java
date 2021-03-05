package org.fimba.warehousemanagmentsystem.service;

import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.awt.*;
import java.util.Collection;

public interface ProductWarehouseService{

    ResponseEntity<?> add(ProductWarehouseDTO dto);

    ResponseEntity<?> transfer(StockTransferDTO dto);

    ResponseEntity<?> update(StockUpdateDTO dto);

    ResponseEntity<Collection<?>> summaries();
}
