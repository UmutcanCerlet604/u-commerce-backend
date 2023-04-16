package com.ecommerce.core.user;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class UserDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private UserRoleDTO userRole;

    public UserDTO(){

    }
}