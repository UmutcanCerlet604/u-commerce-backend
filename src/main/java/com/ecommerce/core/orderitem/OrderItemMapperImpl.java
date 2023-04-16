package com.ecommerce.core.orderitem;

import com.ecommerce.core.basket.BasketDTO;
import com.ecommerce.core.order.OrderEntity;
import org.aspectj.weaver.ast.Or;

import java.io.Serializable;

public class OrderItemMapperImpl implements Serializable {

    public static OrderItemDTO toDto(BasketDTO basketDTO){

        OrderItemDTO result = new OrderItemDTO();

        result.setId(basketDTO.getId());
        result.setName(basketDTO.getProduct().getName());
        result.setPrice(basketDTO.getProduct().getPrice());
        result.setQuantity(basketDTO.getQuantity());
        result.setDescription(basketDTO.getProduct().getDescription());
        result.setImageUrl(basketDTO.getProduct().getImageUrl());

        return result;
    }

    public static OrderItemEntity toEntity(BasketDTO basketDTO,OrderEntity orderEntity){

        OrderItemEntity result = new OrderItemEntity();

        result.setName(basketDTO.getProduct().getName());
        result.setPrice(basketDTO.getProduct().getPrice());
        result.setQuantity(basketDTO.getQuantity());
        result.setDescription(basketDTO.getProduct().getDescription());
        result.setOrderItem(orderEntity);
        result.setImageUrl(basketDTO.getProduct().getImageUrl());

        return result;
    }

    public static OrderItemDTO orderItemToDTO(OrderItemEntity orderItemEntity){

        OrderItemDTO result = new OrderItemDTO();

        result.setId(orderItemEntity.getId());
        result.setDescription(orderItemEntity.getDescription());
        result.setQuantity(orderItemEntity.getQuantity());
        result.setName(orderItemEntity.getName());
        result.setImageUrl(orderItemEntity.getImageUrl());
        result.setPrice(orderItemEntity.getPrice());
        return result;
    }


}
