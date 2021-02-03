package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;
import org.fimba.warehousemanagmentsystem.service.UserCRUDService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserCRUDService userCRUDService;

    @GetMapping
    public WarehouseAPIResponseHolder<Collection<UserDTO>> list() {
        return userCRUDService.list();
    }

    @PostMapping
    public WarehouseAPIResponseHolder<UserDTO> create(@Valid @RequestBody UserDTO dto) {

        return userCRUDService.create(dto);
    }

    @PutMapping
    public WarehouseAPIResponseHolder<UserDTO> update(@Valid @RequestBody UserDTO dto, @PathVariable Long id) {
        return userCRUDService.update(dto,id);
    }

    @DeleteMapping
    public WarehouseAPIResponseHolder<?> delete(@PathVariable Long id) {
        return userCRUDService.delete(id);
    }
}
