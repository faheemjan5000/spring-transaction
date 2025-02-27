package com.example.spring.transaction.repository;

import com.example.spring.transaction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Product,Integer> {
}
