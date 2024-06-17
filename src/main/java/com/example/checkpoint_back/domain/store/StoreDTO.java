package com.example.checkpoint_back.domain.store;

public record StoreDTO(
        Long id,
        String name,
        String address,
        String description,
        String imgUrl
) {
    public static StoreDTO mapFromEntity(Store store) {
        return new StoreDTO(
                store.getId(),
                store.getName(),
                store.getAddress(),
                store.getDescription(),
                store.getImgUrl()
        );
    }
}
