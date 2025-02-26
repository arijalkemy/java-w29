package com.opshowroom.showroom.domain;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
    private Integer size;
    private Integer qty;
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @ManyToMany(mappedBy = "products")
    private Set<Sale> sales;

    @Override
    public String toString() {
        return "Clothe{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", qty=" + qty +
                ", sale_price=" + salePrice +
                ", sales=" + sales +
                '}';
    }
}
