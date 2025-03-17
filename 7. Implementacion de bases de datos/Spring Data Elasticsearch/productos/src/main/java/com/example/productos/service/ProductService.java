package com.example.productos.service;

import com.example.productos.model.Product;
import com.example.productos.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final IProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        product.setId(id);
        return repository.save(product);
    }
}
