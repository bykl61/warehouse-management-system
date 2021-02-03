package org.fimba.warehousemanagmentsystem.service;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;

public interface LoginService {
    WarehouseAPIResponseHolder<UserDTO> login(UserDTO userDTO);
}
