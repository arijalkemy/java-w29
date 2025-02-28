package com.example.vehicles.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "vehicle_id")
    private Long id;

    private String patent;
    private String brand;
    private String model;

    @Column(name = "year_manufacture")
    private Integer yearManufacture;

    private Integer wheels;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Accident> accidents;
}
