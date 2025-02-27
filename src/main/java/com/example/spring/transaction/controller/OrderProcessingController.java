package com.example.spring.transaction.controller;

import com.example.spring.transaction.entity.Order;
import com.example.spring.transaction.exceptions.InsufficientStockException;
import com.example.spring.transaction.service.OrderProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderProcessingController {
    private final OrderProcessingService orderProcessingService;

    public OrderProcessingController(OrderProcessingService orderProcessingService) {
        this.orderProcessingService = orderProcessingService;
    }

    @PostMapping("/new")
    public ResponseEntity<Order> placeOrder(@RequestBody Order newOrder) throws InsufficientStockException {
        log.info("OrderProcessingController.placeOrder() method is called.....");
        return ResponseEntity.ok(orderProcessingService.placeOrder(newOrder));
    }
}
