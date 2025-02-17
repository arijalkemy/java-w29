package com.elasticsearch.productos.service;

import com.elasticsearch.productos.exception.NotFoundException;
import com.elasticsearch.productos.model.Product;
import com.elasticsearch.productos.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public Product update(String id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }
}
