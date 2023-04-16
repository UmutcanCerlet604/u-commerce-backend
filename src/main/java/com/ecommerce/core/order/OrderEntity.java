package com.ecommerce.core.order;


import com.ecommerce.core.orderitem.OrderItemEntity;
import com.ecommerce.core.user.UserEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Entity
@Data
@Table

public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderItem", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItemEntities = new ArrayList<>();
}
