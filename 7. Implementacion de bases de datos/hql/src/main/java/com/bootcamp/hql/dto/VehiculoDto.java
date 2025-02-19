package com.bootcamp.hql.dto;

import lombok.Data;

@Data
public class VehiculoDto {
    private int id;
    private String licensePlate;
    private String brand;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
}
