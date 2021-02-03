package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;
import org.fimba.warehousemanagmentsystem.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouseapi/user/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
   public WarehouseAPIResponseHolder<UserDTO> login (@RequestBody UserDTO userDTO){

        return loginService.login(userDTO);
    }
}
