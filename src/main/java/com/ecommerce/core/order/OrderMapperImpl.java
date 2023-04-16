package com.ecommerce.core.order;


import com.ecommerce.core.orderitem.OrderItemEntityRepository;
import com.ecommerce.core.orderitem.OrderItemMapperImpl;
import com.ecommerce.core.user.UserMapperImpl;

import java.io.Serializable;

public class OrderMapperImpl implements Serializable {

    public static OrderDTO toDto(OrderEntity orderEntity){
        OrderDTO result = new OrderDTO();
        result.setId(orderEntity.getId());
        result.setDate(orderEntity.getDate());
        result.setUser(UserMapperImpl.toDTO(orderEntity.getUserEntity()));
        orderEntity.getOrderItemEntities().stream().forEach(orderItemEntity -> {
            result.getOrderItemDTOS().add(OrderItemMapperImpl.orderItemToDTO(orderItemEntity));
        });


        return result;
    }

    public static OrderEntity toEntity(OrderDTO orderDTO){
        OrderEntity result = new OrderEntity();
        result.setId(orderDTO.getId());
        result.setDate(orderDTO.getDate());

        return result;
    }
}
