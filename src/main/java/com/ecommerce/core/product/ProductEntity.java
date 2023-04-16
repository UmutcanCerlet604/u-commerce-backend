package com.ecommerce.core.product;

import com.ecommerce.core.brand.BrandEntity;
import com.ecommerce.core.category.CategoryEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Data
@Table
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer piece;

    @Column(length = 1023)
    private String description;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false)
    private BrandEntity brandEntity;


}
