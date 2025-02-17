package com.bootcampw29.jewelry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 35)
    private String material;

    @Column(name = "weight_in_g")
    private Double weightInG;

    private String particularity;

    @Column(name = "has_stone")
    private Boolean hasStone;

    @Column(name = "is_for_sale")
    private Boolean isForSale;
}
