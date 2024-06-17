package com.example.checkpoint_back.domain.store;

import com.example.checkpoint_back.domain.product.Product;

import java.util.List;

public record StoreDTO(
        Long id,
        String name,
        String address,
        String description,
        String imgUrl,
        List<Long>productIds
) {
    public static StoreDTO mapFromEntity(Store store) {
        return new StoreDTO(
                store.getId(),
                store.getName(),
                store.getAddress(),
                store.getDescription(),
                store.getImgUrl(),
                store.getProductList().stream().map(Product::getId).toList()
        );
    }
}
