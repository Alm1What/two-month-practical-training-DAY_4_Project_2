package org.example.day_4_practice_project_two.controller;

import org.example.day_4_practice_project_two.dto.ProductDto;
import org.example.day_4_practice_project_two.service.impl.ProductImplService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private ProductImplService productImplService;

    public ProductController(ProductImplService productImplService) {
        this.productImplService = productImplService;
    }

    @PostMapping()
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productImplService.create(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(productImplService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long productId) {
        return ResponseEntity.ok(productImplService.findById(productId));
    }

    @DeleteMapping("/{deleteProductId}")
    public ResponseEntity<ProductDto> delete(@PathVariable Long deleteProductId) {
        return ResponseEntity.ok(productImplService.delete(deleteProductId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto, @PathVariable Long productId) {
        return ResponseEntity.ok(productImplService.update(productDto, productId));
    }
}
