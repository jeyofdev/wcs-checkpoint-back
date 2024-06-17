package com.example.checkpoint_back.domain.category;

public record CategoryDTO(
        Long id,
        String name,
        String imgUrl
) {
    public static CategoryDTO mapFromEntity(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getImgUrl()
        );
    }
}
