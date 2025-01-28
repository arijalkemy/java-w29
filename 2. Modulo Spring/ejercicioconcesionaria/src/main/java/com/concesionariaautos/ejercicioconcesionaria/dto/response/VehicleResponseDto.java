package com.concesionariaautos.ejercicioconcesionaria.dto.response;

import com.concesionariaautos.ejercicioconcesionaria.entity.ServiceVehicle;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleResponseDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<ServiceVehicle> serviceVehicleList;
    private Integer countOfOwners;
}
