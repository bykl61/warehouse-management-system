package org.fimba.warehousemanagmentsystem.exception;

import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WarehouseAPIExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> ExceptionHandlingResourceNotFound(ResourceNotFoundException exception){
        WarehouseAPIResponseError warehouseAPIResponseError =
                new WarehouseAPIResponseError("ResourceNotFoundException",
                        exception.getMessage());
        return new ResponseEntity<>(warehouseAPIResponseError,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ExceptionHandlingValidation(MethodArgumentNotValidException exception){
        WarehouseAPIResponseError warehouseAPIResponseError =
                new WarehouseAPIResponseError("VALIDATION ERROR",
                        exception.getBindingResult().getFieldError().getDefaultMessage());

        return  new ResponseEntity<>(warehouseAPIResponseError,HttpStatus.BAD_REQUEST);
    }
}
