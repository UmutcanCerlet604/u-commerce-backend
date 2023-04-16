package com.ecommerce.core.orderitem;


import com.ecommerce.core.basket.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private")
public class OrderItemResource {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping(path = "/addOrderItem")
    public ResponseEntity<List<OrderItemDTO>> addOrder(){
        return ResponseEntity.ok(orderItemService.addOrderItem());
    }

}
