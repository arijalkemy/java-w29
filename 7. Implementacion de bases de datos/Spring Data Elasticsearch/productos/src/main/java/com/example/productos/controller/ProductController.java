package com.example.productos.controller;

import com.example.productos.model.Product;
import com.example.productos.service.IProductService;
import com.example.productos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final IProductService service;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @RequestBody Product product,
            @PathVariable String id) {
        return ResponseEntity.ok(service.update(id, product));
    }
}
