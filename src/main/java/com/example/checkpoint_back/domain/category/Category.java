package com.example.checkpoint_back.domain.category;

import com.example.checkpoint_back.domain.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name="img_url", columnDefinition = "TEXT", nullable = false)
    private String imgUrl;
}
