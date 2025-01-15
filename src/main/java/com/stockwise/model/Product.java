package com.stockwise.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data // Lombok ajuda a reduzir boilerplate (getters/setters)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private double price;

    @Column(name = "min_stock")
    private int minStock;
}
