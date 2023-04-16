package com.ecommerce.core.category;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@ToString
@Entity
@Data
@Table
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}
