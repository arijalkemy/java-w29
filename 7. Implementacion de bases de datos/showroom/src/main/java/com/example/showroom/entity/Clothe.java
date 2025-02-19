package com.example.showroom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clothes")
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code, name, type, brand, color, size;
    private Integer quantity;
    @Column(name = "price_sale")
    private double priceSale;

    @OneToMany(mappedBy = "clothe", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SaleDetail> saleDetails;
}
