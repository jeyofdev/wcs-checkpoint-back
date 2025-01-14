package com.example.checkpoint_back.domain.category;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> add(@RequestBody Category category) {
        Category newCategory = categoryService.add(category);
        CategoryDTO categoryDTO = CategoryDTO.mapFromEntity(newCategory);

        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> categoryList = categoryService.findAll();
        List<CategoryDTO> categoryDTOList = categoryList.stream().map(CategoryDTO::mapFromEntity).toList();

        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long categoryId) {
        Category category = categoryService.findById(categoryId);
        CategoryDTO categoryDTO = CategoryDTO.mapFromEntity(category);

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> delete(@PathVariable Long categoryId) {
        String result = categoryService.deleteById(categoryId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateById(@RequestBody Category category, @PathVariable Long categoryId) {
        Category categoryToUpdated = categoryService.updateById(category, categoryId);
        CategoryDTO categoryDTO = CategoryDTO.mapFromEntity(categoryToUpdated);

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

}
