package com.example.checkpoint_back.domain.category;

import com.example.checkpoint_back.domain.product.Product;
import com.example.checkpoint_back.domain.product.ProductDTO;

import java.util.List;

public record CategoryDTO(
        Long id,
        String name,
        String imgUrl,
        List<ProductDTO> products

) {
    public static CategoryDTO mapFromEntity(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getImgUrl(),
                category.getProducts().stream().map(ProductDTO::mapFromEntity).toList()
        );
    }
}
