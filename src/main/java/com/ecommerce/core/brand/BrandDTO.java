package com.ecommerce.core.brand;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BrandDTO implements Serializable {

    private Long id;
    private String brandName;
}
