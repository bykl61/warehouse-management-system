package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseTransferDTO;
import org.fimba.warehousemanagmentsystem.service.WarehouseTransferOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouse/transfer")

public class WarehouseTransferOperationController {
    private final WarehouseTransferOperationService transferOperationService;

    @PostMapping
    public WarehouseAPIResponseHolder<?> transfer(@RequestBody WarehouseTransferDTO dto){

        return transferOperationService.transfer(dto);
    }

}
