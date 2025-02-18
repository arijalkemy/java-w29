package com.bootcamp.hqlvivo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private Integer manufacturingYear;
    private Integer wheels;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleId")
    private List<Accident> accidents;

    public Vehicle(String licensePlate, String brand) {
        this.licensePlate = licensePlate;
        this.brand = brand;
    }

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
