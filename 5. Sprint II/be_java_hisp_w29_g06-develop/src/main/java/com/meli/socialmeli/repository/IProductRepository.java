package com.meli.socialmeli.repository;

import com.meli.socialmeli.entity.Product;

import java.util.Optional;

public interface IProductRepository {
    Optional<Product> getById(Integer id);
    Optional<Product> save(Product product);
}
