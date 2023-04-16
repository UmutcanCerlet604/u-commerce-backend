package com.ecommerce.core.order;

import com.ecommerce.core.orderitem.OrderItemDTO;
import com.ecommerce.core.user.UserDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class OrderDTO implements Serializable {

    private Long id;
    private Date date;
    private UserDTO user;
    private List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
}
