package com.example.spring.transaction.service;

import com.example.spring.transaction.entity.Product;
import com.example.spring.transaction.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Product getProduct(int productId){
        return inventoryRepository.findById(productId)
                .orElseThrow(
                        ()->new RuntimeException("product not found")
                );
    }

    public Product updateProductDetails(Product product) {
        return inventoryRepository.save(product);
    }
}
