package com.example.carDealership.service;

import com.example.carDealership.dto.VehicleDto;

import java.util.List;

public interface IVehiclesService {
    VehicleDto addNewVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getAllVehicles();
    List<VehicleDto> geAllVehiclesByManufacturingDate(String startDate, String endDate);
    List<VehicleDto> geAllVehiclesByPrice(Double since, Double to);
    VehicleDto findVehicle(Long id);
}
