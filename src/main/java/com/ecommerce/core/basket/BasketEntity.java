package com.ecommerce.core.basket;


import com.ecommerce.core.product.ProductEntity;
import com.ecommerce.core.user.UserEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Data
@Table

public class BasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long quantity;

    @OneToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private ProductEntity productEntity;
}
