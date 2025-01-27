package com.example.proyectoBase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private int year;
    private String color;
    private int max_speed;
    private String fuel_type;
    private String transmission;
    private int passengers;
    private double height;
    private double width;
    private double weight;
}
