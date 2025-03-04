package com.example.products.repository;

import com.example.products.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {
}
