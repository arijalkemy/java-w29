package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.Product;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query("""
        SELECT p.id AS idProduct, SUM(pb.currentQuantity) AS quantity 
        FROM Product p 
        LEFT JOIN ProductBatch pb ON pb.product.id = p.id 
        GROUP BY p.id
    """)
    List<ProductProjection> findAllProducts();

    @Query("""
        SELECT p.id AS idProduct, SUM(pb.currentQuantity) AS quantity 
        FROM Product p 
        LEFT JOIN ProductBatch pb ON pb.product.id = p.id 
        WHERE p.productType = :category 
        GROUP BY p.id
    """)
    List<ProductProjection> findProductsByCategory(ProductType category);
}


