package com.rakeshkumarr.cartapp.controller;

import com.rakeshkumarr.cartapp.dto.CreateOrderRequest;
import com.rakeshkumarr.cartapp.dto.OrderCreated;
import com.rakeshkumarr.cartapp.entity.Order;
import com.rakeshkumarr.cartapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest){
        OrderCreated orderCreated = orderService.createOrder(orderRequest);
        return ResponseEntity.ok().body(orderCreated);
    }

    @GetMapping("/{referenceId}")
    public ResponseEntity<?> gerOrder(@PathVariable String referenceId){
        Order order = orderService.getOrder(referenceId);
        return ResponseEntity.ok().body(order);
    }
}
