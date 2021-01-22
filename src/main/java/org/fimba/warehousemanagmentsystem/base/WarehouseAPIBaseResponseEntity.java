package org.fimba.warehousemanagmentsystem.base;

import org.fimba.warehousemanagmentsystem.model.dto.BaseDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface WarehouseAPIBaseResponseEntity<T extends BaseDTO> {
    ResponseEntity<Collection<T>> list();

    ResponseEntity<T> create(T dto);

    ResponseEntity<T> update(T dto);

    ResponseEntity<?> delete(T id);
}
