package com.ecommerce.core.user;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Data
@Table
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name="userRoleId",nullable = false)
    private UserRoleEntity userRole;

    public UserEntity(){

    }

}