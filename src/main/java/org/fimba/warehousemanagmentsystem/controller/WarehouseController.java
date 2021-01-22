package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.service.WarehouseCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseCRUDService warehouseCRUDService;

    @GetMapping
    public ResponseEntity<Collection<WarehouseDTO>> list() {
        return warehouseCRUDService.list();
    }

    @PostMapping
    public ResponseEntity<WarehouseDTO> create(@RequestBody WarehouseDTO dto) {

        return warehouseCRUDService.create(dto);
    }

    @PutMapping
    public ResponseEntity<WarehouseDTO> update(@RequestBody WarehouseDTO dto) {
        return warehouseCRUDService.update(dto);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody WarehouseDTO id) {
        return null;
    }
}
