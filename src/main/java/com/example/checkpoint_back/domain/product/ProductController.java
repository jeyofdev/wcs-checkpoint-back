package com.example.checkpoint_back.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductDTO> add(@RequestBody Product product) {
        Product newProduct = productService.add(product);
        ProductDTO productDTO = ProductDTO.mapFromEntity(newProduct);

        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> productList = productService.findAll();
        List<ProductDTO> productDTOList = productList.stream().map(ProductDTO::mapFromEntity).toList();

        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long productId) {
        Product product = productService.findById(productId);
        ProductDTO productDTO = ProductDTO.mapFromEntity(product);

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> delete(@PathVariable Long productId) {
        String result = productService.deleteById(productId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateById(@RequestBody Product product, @PathVariable Long productId) {
        Product categoryToUpdated = productService.updateById(product, productId);
        ProductDTO productDTO = ProductDTO.mapFromEntity(categoryToUpdated);

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
