package com.ecommerce.core.product;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ProductDTO implements Serializable {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private Integer piece;
    private Long categoryId;
    private Long brandId;

}
