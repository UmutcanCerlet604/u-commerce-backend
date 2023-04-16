package com.ecommerce.core.basket;

import com.ecommerce.core.product.ProductDTO;
import com.ecommerce.core.product.ProductEntity;
import com.ecommerce.core.user.UserDTO;
import com.ecommerce.core.user.UserEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BasketDTO implements Serializable {

    private Long id;
    private Long quantity;
    private UserDTO user;
    private ProductDTO product;
}
