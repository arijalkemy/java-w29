package com.example.hqlvehiculos.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String patent;
    String brand;
    String model;
    Integer year;
    @Column(name = "number_of_wheels")
    Integer numberOfWheels;
}
