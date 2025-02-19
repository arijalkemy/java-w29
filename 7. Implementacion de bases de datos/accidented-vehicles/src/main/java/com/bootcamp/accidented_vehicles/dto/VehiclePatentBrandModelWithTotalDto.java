package com.bootcamp.accidented_vehicles.dto;

import lombok.Data;

import java.util.List;

@Data
public class VehiclePatentBrandModelWithTotalDto {
    private List<VehiclePatentBrandModelDto> patentBrandModel;
    private double total;
}
