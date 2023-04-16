package com.ecommerce.core.user;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserRoleDTO {

    private Long id;
    private String userRole;

    public UserRoleDTO(){

    }
}
