package com.example.spring.transaction.service;

import com.example.spring.transaction.entity.Order;
import com.example.spring.transaction.entity.Product;
import com.example.spring.transaction.exceptions.InsufficientStockException;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {
    private final OrderService orderService;
    private final InventoryService inventoryService;

    public OrderProcessingService(OrderService orderService, InventoryService inventoryService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
    }

    public Order placeOrder(Order newOrder) throws InsufficientStockException {
     // get the product from the inventory
     // validate stock availability
     // update total price in order entity
     // save the order
     // updated stock in inventory
        Product productRetrieved = inventoryService.getProduct(newOrder.getProductId());
        if(newOrder.getQuantity()> productRetrieved.getAvailableQuantity()){
            throw new InsufficientStockException("Insuffecient stock availability");
        }
        newOrder.setTotalPrice(newOrder.getQuantity() * productRetrieved.getPrice());
        orderService.saveOrder(newOrder);
        productRetrieved.setAvailableQuantity(productRetrieved.getAvailableQuantity() - newOrder.getQuantity());
        inventoryService.updateProductDetails(productRetrieved);
    return newOrder;

    }

}
