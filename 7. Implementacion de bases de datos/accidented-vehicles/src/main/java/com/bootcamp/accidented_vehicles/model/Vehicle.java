package com.bootcamp.accidented_vehicles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String patent;
    private String brand;
    private String model;
    @Column(name = "manufacture_year")
    private int manufactureYear;
    @Column(name = "number_of_wheels")
    private short numberOfWheels;
    @OneToMany(mappedBy = "vehicle")
    private List<Sinister> sinisters;
}
