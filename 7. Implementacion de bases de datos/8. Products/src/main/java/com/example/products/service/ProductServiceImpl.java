package com.example.products.service;

import com.example.products.dto.ProductDTO;
import com.example.products.model.Product;
import com.example.products.repository.IProductRepository;
import com.example.products.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = repository.save(ProductMapper.INSTANCE.productDTOToProduct(productDTO));
        return ProductMapper.INSTANCE.productToProductDTO(product);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = repository.save(ProductMapper.INSTANCE.productDTOToProduct(productDTO));
        return ProductMapper.INSTANCE.productToProductDTO(product);
    }

    @Override
    public ProductDTO deleteById(String id) {
        Optional<Product> product = repository.findById(id);
        repository.delete(product.get());
        return ProductMapper.INSTANCE.productToProductDTO(product.get());
    }

    @Override
    public ProductDTO findById(String id) {
        Optional<Product> product = repository.findById(id);
        return ProductMapper.INSTANCE.productToProductDTO(product.get());
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        repository.findAll().forEach(productDTO -> productDTOS.add(ProductMapper.INSTANCE.productToProductDTO(productDTO)));
        return productDTOS;
    }
}
