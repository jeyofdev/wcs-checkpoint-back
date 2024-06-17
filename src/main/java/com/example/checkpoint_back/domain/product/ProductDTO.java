package com.example.checkpoint_back.domain.product;


import com.example.checkpoint_back.domain.category.Category;

import java.util.List;

public record ProductDTO(
    Long id,
    String name,
    double price,
    String description,
    String imgUrl,
    Long storeId

) {
        public static ProductDTO mapFromEntity(Product product) {
            return new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getImgUrl(),
                    product.getStore().getId()

            );
        }
}
