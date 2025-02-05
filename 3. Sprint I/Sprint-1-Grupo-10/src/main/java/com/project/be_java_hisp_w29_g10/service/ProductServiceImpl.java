package com.project.be_java_hisp_w29_g10.service;

import com.project.be_java_hisp_w29_g10.entity.Product;
import com.project.be_java_hisp_w29_g10.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product newProduct) {
        return productRepository.save(newProduct);
    }
}
