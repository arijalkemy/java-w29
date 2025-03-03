package com.opshowroom.showroom.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "clothes")
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer qty;
    @Column(name = "sale_price")
    private Long salePrice;
    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private Set<Sale> sales;
}
