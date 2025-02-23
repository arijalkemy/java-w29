package com.hqlvivo.hqlvivo.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table(name = "vehiculos")

public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private Integer vehicleYear;
    private Integer wheels;

    @OneToMany(mappedBy = "vehicle")
    private Set<SiniestroModel> siniestros;

    @Override
    public String toString() {
        return "VehicleModel{" +
                "id=" + id +
                ", patent='" + patent + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", wheels=" + wheels +
                ", siniestros=" + siniestros +
                '}';
    }
}
