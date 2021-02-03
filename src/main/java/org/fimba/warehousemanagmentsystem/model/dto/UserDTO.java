package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.UserStatus;


import javax.validation.constraints.Email;

@Getter
@Setter
public class UserDTO extends BaseDTO{

    @Email(message = "You must enter a valid email!")
    private String email;
    private String password;
    private UserStatus status = UserStatus.ACTIVE;
}
