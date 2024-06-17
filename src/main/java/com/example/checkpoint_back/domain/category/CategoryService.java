package com.example.checkpoint_back.domain.category;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Category with id " + id + " not found. 😤☹️")
                );
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    public Category deleteById(Long id) {
        Category categoryToDeleted = findById(id);
        categoryRepository.deleteById(id);

        return categoryToDeleted;
    }

    public Category updateById(Category category, Long id) {
        Category categoryToUpdated = findById(id);
        System.out.println(categoryToUpdated.getName());

        categoryToUpdated.setName(category.getName());
        categoryToUpdated.setImgUrl(category.getImgUrl());

        return categoryRepository.save(categoryToUpdated);
    }


}
