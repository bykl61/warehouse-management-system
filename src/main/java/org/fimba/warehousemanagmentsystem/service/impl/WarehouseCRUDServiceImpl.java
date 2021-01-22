package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.convertor.ConvertToWarehouseDTO;
import org.fimba.warehousemanagmentsystem.convertor.ConvertToWarehouseEntity;
import org.fimba.warehousemanagmentsystem.dao.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.WarehouseCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WarehouseCRUDServiceImpl implements WarehouseCRUDService {

    private final ConvertToWarehouseDTO convertToWarehouseDTO;
    private final ConvertToWarehouseEntity convertToWarehouseEntity;
    private final WarehouseCRUDRepository warehouseCRUDRepository;

    @Override
    public ResponseEntity<Collection<WarehouseDTO>> list() {
        Collection<WarehouseEntity> warehouseEntities = warehouseCRUDRepository.findAllActiveAndPassive();
        List<WarehouseDTO> warehouseDTOList = warehouseEntities
                .stream()
                .map(convertToWarehouseDTO::convertor)
                .collect(Collectors.toList());
        return ResponseEntity.ok(warehouseDTOList);
    }

    @Override
    public ResponseEntity<WarehouseDTO> create(WarehouseDTO dto) {
        WarehouseEntity warehouseEntity = convertToWarehouseEntity.convertor(dto);
        warehouseEntity.setCreatedDate(new Date());
        WarehouseEntity savedEntity = warehouseCRUDRepository.save(warehouseEntity);
        WarehouseDTO warehouseDTO = convertToWarehouseDTO.convertor(savedEntity);
        return ResponseEntity.ok(warehouseDTO);
    }

    @Override
    public ResponseEntity<WarehouseDTO> update(WarehouseDTO dto) {
        WarehouseEntity updateEntity = convertToWarehouseEntity.convertor(dto);
        updateEntity.setUpdatedDate(new Date());
        WarehouseEntity updatedEntity = warehouseCRUDRepository.save(updateEntity);
        warehouseCRUDRepository.findById(dto.getId());
        WarehouseDTO warehouseDTO = convertToWarehouseDTO.convertor(updatedEntity);
        return ResponseEntity.ok(warehouseDTO);
    }

    @Override
    public ResponseEntity<?> delete(WarehouseDTO id) {
         warehouseCRUDRepository.deleteById(id.getId());
        return null;
    }

}
