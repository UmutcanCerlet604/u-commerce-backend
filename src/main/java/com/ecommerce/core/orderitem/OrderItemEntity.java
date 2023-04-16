package com.ecommerce.core.orderitem;

import com.ecommerce.core.order.OrderEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Data
@Table

public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Long quantity;

    @Column(length = 1023)
    private String description;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity orderItem;

}
