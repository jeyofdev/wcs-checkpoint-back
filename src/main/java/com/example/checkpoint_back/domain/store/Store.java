package com.example.checkpoint_back.domain.store;

import com.example.checkpoint_back.domain.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "address", columnDefinition = "VARCHAR(255)", nullable = false)
    private String address;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "img_url", columnDefinition = "TEXT", nullable = false)
    private String imgUrl;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
}
