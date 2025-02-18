package com.bootcamp.hqlvivo.dto;


import lombok.Data;

@Data
public class VehicleAccidentTotalLossDTO {
    private String licensePlate;
    private String brand;
    private String model;
    private Double totalLoss;
}
