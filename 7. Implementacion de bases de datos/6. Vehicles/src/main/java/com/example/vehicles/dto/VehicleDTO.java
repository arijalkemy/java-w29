package com.example.vehicles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private Integer yearManufacture;
    private Integer wheels;
}
