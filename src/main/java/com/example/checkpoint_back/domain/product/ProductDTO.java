package com.example.checkpoint_back.domain.product;


public record ProductDTO(
    Long id,
    String name,
    double price,
    String description,
    String imgUrl
) {
        public static ProductDTO mapFromEntity(Product product) {
            return new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getImgUrl()
            );
        }
}
