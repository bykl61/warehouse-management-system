package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.dao.LoginRepository;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.exception.WarehouseAPIResponseError;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Override
    public WarehouseAPIResponseHolder<UserDTO> login(UserDTO userDTO) {

       String email = userDTO.getEmail();
       String password = userDTO.getPassword();
       UserEntity userEntity = loginRepository.findUserEntityByEmailAndPassword(email,password);
       if(userEntity==null){
           throw  new ResourceNotFoundException("EMAIL OR PASSWORD WRONG");
       }



        return new WarehouseAPIResponseHolder<>(HttpStatus.OK);
    }
}
