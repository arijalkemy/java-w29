package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clothes")
@Data
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    private String name;

    private String type;

    @ManyToOne
    @JoinColumn(name = "id_brand", referencedColumnName = "id")
    private Brand brand;

    private String size;

    private String color;

    private Integer stock;

    private Double price;
}
