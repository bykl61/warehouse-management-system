package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.config.SecurityConfig;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;
import org.fimba.warehousemanagmentsystem.service.LoginService;
import org.springframework.http.HttpStatus;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {


    @GetMapping("login")
    public String message() {
        return "login";
    }


}
