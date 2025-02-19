package com.example.ThePearls.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "jewel")
@Data
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_number;

    private String name;
    private String material;
    private Double weight;
    private String particularity;

    @Column(name = "own_stone")
    private Boolean ownStone;

    @Column(name = "sale_or_not")
    private Boolean saleOrNot = true;
}
