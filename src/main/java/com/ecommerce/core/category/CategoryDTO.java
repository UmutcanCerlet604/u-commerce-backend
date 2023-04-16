package com.ecommerce.core.category;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CategoryDTO implements Serializable {

    private Long id;
    private String name;


}
