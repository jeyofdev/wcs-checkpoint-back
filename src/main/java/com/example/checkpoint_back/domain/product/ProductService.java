package com.example.checkpoint_back.domain.product;

import com.example.checkpoint_back.domain.category.Category;
import com.example.checkpoint_back.domain.category.CategoryRepository;
import com.example.checkpoint_back.domain.store.Store;
import com.example.checkpoint_back.domain.store.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Product with id " + id + " not found. 😤☹️")
                );
    }

    public Product add(Product product, Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Store with id " + storeId + " not found. 😤☹️")
                );

        product.setStore(store);
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

    public Category addCourse(Category category) {
        return categoryRepository.save(category);
    }

    public void addCategoryToProduct(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Store with id " + productId + " not found. 😤☹️"));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Store with id " + categoryId + " not found. 😤☹️"));

        product.getCategories().add(category);
        productRepository.save(product);
    }
}
