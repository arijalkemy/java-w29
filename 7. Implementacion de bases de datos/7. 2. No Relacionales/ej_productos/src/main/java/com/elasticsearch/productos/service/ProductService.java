package com.elasticsearch.productos.service;

import com.elasticsearch.productos.model.Product;

public interface ProductService {
    Iterable<Product> getAll();

    Product save(Product product);

    Product getById(String id);

    Product update(String id, Product product);
}
