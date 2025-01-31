package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AverageCapacityDTO {
    private String brand;
    private Double averageCapacity;
}
