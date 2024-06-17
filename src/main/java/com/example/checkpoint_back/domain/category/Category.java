package com.example.checkpoint_back.domain.category;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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
