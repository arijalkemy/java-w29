package com.meli.socialmeli.repository;

import com.meli.socialmeli.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private List<Product> products;

    public ProductRepositoryImpl() {
        products = new ArrayList<>();
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Product> save(Product product) {
        Optional<Product> existingProduct = getById(product.getId());

        if (existingProduct.isPresent()) {
            return Optional.empty();
        }

        products.add(product);
        return Optional.of(product);
    }
}
