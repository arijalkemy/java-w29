package com.example.productos.service;

import com.example.productos.model.Product;

public interface IProductService {
    Product save(Product product);

    Product update(String id, Product product);
}
