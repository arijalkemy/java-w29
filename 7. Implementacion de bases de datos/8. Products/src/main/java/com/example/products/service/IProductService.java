package com.example.products.service;

import com.example.products.dto.ProductDTO;
import java.util.List;

public interface IProductService {
    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    ProductDTO deleteById(String id);
    ProductDTO findById(String id);
    List<ProductDTO> findAll();
}
