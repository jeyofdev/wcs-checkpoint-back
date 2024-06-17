package com.example.checkpoint_back.domain.product;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Product with id " + id + " not found. 😤☹️")
                );
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public String deleteById(Long id) {
        Product productToDeleted = findById(id);
        productRepository.deleteById(id);
        return "Product " + productToDeleted.getName() + " has been deleted successfully.";
    }

    public Product updateById(Product product, Long id) {
        Product productToUpdated = findById(id);

        productToUpdated.setName(product.getName());
        productToUpdated.setPrice(product.getPrice());
        productToUpdated.setDescription(product.getDescription());
        productToUpdated.setImgUrl(product.getImgUrl());

        return productRepository.save(productToUpdated);
    }
}
