package com.mercadolibre.final_project_bootcamp_esp_32.entities;

import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
