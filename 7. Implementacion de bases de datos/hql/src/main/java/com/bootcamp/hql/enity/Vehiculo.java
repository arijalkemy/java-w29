package com.bootcamp.hql.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String licensePlate;
    private String brand;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;
}
