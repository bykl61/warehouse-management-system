package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.model.dto.ID;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("stocks")
public class StockController {
    private final StockService stockService;

    @GetMapping()
    public List<WarehouseEntity> list(){
        return stockService.list();
    }

    @PostMapping
    public void update(@RequestBody StockUpdateDTO stockUpdateDTO){
        stockService.update(stockUpdateDTO);
    }
}
