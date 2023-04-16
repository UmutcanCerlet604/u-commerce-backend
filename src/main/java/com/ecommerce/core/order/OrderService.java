package com.ecommerce.core.order;


import com.ecommerce.core.orderitem.OrderItemDTO;
import com.ecommerce.core.orderitem.OrderItemEntity;
import com.ecommerce.core.orderitem.OrderItemService;
import com.ecommerce.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    public List<OrderDTO> getAllOrder(){
        List<OrderDTO> orderDTOList = new ArrayList<>();

        orderEntityRepository.findAll().stream().filter(e -> e.getUserEntity().getId().equals(userService.getCurrentUser().getId())).forEach(orderEntity -> {
            orderDTOList.add(OrderMapperImpl.toDto(orderEntity));
        });

        return orderDTOList;

    }
}
