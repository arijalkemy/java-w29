package com.concesionariaautos.ejercicioconcesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceVehicle {
    private String date;
    private String kilometers;
    private String descriptions;
}
