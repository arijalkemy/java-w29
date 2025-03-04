package com.example.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private Double salePrice;
    private Double costPrice;
    private Integer availableQuantity;
}


