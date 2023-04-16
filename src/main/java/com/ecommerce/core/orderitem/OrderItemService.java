package com.ecommerce.core.orderitem;

import com.ecommerce.core.basket.BasketDTO;
import com.ecommerce.core.basket.BasketService;
import com.ecommerce.core.order.OrderEntity;
import com.ecommerce.core.order.OrderEntityRepository;
import com.ecommerce.core.user.UserEntity;
import com.ecommerce.core.user.UserService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private BasketService basketService;

    @Autowired
    private OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private UserService userService;


    public List<OrderItemDTO> addOrderItem(){

        OrderEntity orderEntity = new OrderEntity();
        Date date = new Date();
        orderEntity.setDate(date);
        orderEntity.setUserEntity(userService.getCurrentUser());
        OrderEntity orderEntity1 = orderEntityRepository.save(orderEntity);

        List<BasketDTO> basketDTOList = basketService.getAll(userService.getCurrentUser().getId());
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        basketDTOList.stream().forEach(basketDTO -> {
            orderItemEntityRepository.save(OrderItemMapperImpl.toEntity(basketDTO,orderEntity1));
            orderItemDTOList.add(OrderItemMapperImpl.toDto(basketDTO));

        });

        return orderItemDTOList;
    }

}
