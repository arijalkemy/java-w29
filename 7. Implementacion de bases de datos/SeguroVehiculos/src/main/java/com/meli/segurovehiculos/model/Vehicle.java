package com.meli.segurovehiculos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String plate;

    private String type;

    private String model;

    private String brand;

    private Integer year;

    @Column(name = "number_of_wheels")
    private Integer numberOfWheels;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Accident> accidents;
}
