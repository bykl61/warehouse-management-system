package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.dao.UserOperationRepository;
import org.fimba.warehousemanagmentsystem.service.UserOperationService;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserOperationServiceImpl implements UserOperationService {

    private final UserOperationRepository userOperationRepository;

    @Override
    public boolean isExist(String code, String email) {
        if(userOperationRepository.findUserEntityByCodeOrEmail(code,email)==null){
            return false;
        }
        return true;
    }
}
