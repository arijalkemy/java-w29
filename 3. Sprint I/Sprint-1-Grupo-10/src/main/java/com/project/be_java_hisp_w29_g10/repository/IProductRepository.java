package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Product;

public interface IProductRepository {
    Product getById(Long id);
    Product save(Product newProduct);
    Boolean delete(Product product);
}
