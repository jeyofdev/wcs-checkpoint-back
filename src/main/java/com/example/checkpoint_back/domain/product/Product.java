package com.example.checkpoint_back.domain.product;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "price", columnDefinition = "DOUBLE", nullable = false)
    private double price;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "img_url", columnDefinition = "TEXT", nullable = false)
    private String imgUrl;
}
