package com.ecommerce.core.orderitem;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OrderItemDTO implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private Long quantity;
    private String description;
    private String imageUrl;
    private Long orderId;


}
