package com.example.products.controller;

import com.example.products.dto.ProductDTO;
import com.example.products.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    @PostMapping("/new")
    public ResponseEntity<ProductDTO> newProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.create(productDTO));
    }

    @PutMapping("/udpate")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.update(productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable String id) {
        return ResponseEntity.ok(productService.deleteById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
