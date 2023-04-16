package com.ecommerce.core.brand;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@ToString
@Entity
@Data
@Table
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brandName;

}