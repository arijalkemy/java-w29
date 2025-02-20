package com.org.meli.vehiculoshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;
    private String licensePlate;
    private String brand;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Accident> accidents = new ArrayList<>();
}
