package com.ecommerce.core.order;

import com.ecommerce.core.orderitem.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/private")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping( path = "/getAllOrder")
    private ResponseEntity<List<OrderDTO>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
}
