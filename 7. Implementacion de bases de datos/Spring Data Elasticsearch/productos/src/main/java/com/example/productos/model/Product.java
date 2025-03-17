package com.example.productos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Document(indexName = "products")
@Data
public class Product {
    @Id
    private String id;

    private String name;

    private String type;

    private BigDecimal sellingPrice;

    private BigDecimal costPrice;

    private Integer stock;
}
