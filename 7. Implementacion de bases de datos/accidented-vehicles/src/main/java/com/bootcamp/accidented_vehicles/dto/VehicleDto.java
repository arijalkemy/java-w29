package com.bootcamp.accidented_vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VehicleDto {
    private String patent;
    private String brand;
    private String model;
    @JsonProperty("manufacture_year")
    private int manufactureYear;
    @JsonProperty("number_of_wheels")
    private short numberOfWheels;
}
