package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    List<Product> products;

    public ProductRepositoryImpl(){
        products = new ArrayList<>(products = List.of(
                new Product(1L, "Laptop", "Electronics", "Dell", "Black", "Gaming laptop"),
                new Product(2L, "Smartphone", "Electronics", "Samsung", "Blue", "Latest model"),
                new Product(3L, "Refrigerator", "Appliances", "LG", "Silver", "Double door"),
                new Product(4L, "T-shirt", "Clothing", "Nike", "White", "Cotton fabric"),
                new Product(5L, "Sneakers", "Footwear", "Adidas", "Red", "Running shoes"),
                new Product(6L, "Watch", "Accessories", "Casio", "Gold", "Digital watch"),
                new Product(7L, "Headphones", "Electronics", "Sony", "Black", "Noise canceling"),
                new Product(8L, "Chair", "Furniture", "Ikea", "Brown", "Ergonomic chair"),
                new Product(9L, "Backpack", "Accessories", "North Face", "Grey", "Waterproof"),
                new Product(10L, "Desk", "Furniture", "Ikea", "White", "Wooden desk")
        ));

    }

    public Product getById(Long id){
        return  products.stream().filter(product -> product.getProduct_id().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Product save(Product newProduct) {
        products.add(newProduct);
        return newProduct;
    }

    @Override
    public Boolean delete(Product product) {
        products.remove(product);
        return true;
    }
}
