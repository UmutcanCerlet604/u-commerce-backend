package com.ecommerce.core.user;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Data
@Table
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecommerce_generator")
    @SequenceGenerator(name="ecommerce_generator",sequenceName = "ecommerce_seq",allocationSize = 50)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private UserRoleEnum userRole;

    @OneToMany(mappedBy="userRole",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserEntity> users = new ArrayList<>();

    public UserRoleEntity(){

    }


}
