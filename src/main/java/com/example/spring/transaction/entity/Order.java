package com.example.spring.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders_table")
public class Order {
    @Id
    private int orderId;
    private int productId;
    private int quantity;
    private double totalPrice;
}
