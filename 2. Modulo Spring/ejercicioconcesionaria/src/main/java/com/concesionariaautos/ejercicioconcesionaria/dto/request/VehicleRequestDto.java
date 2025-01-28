package com.concesionariaautos.ejercicioconcesionaria.dto.request;

import com.concesionariaautos.ejercicioconcesionaria.entity.ServiceVehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRequestDto {
    private Long id;
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
