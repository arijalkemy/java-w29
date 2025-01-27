package com.example.proyectoBase.service;

import com.example.proyectoBase.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto findVehicleById(Long id);
    VehicleDto addVehicle(VehicleDto vehicleDto);
    VehicleDto updateVehicle(VehicleDto vehicleDto);
    void deleteVehicle(Long id);
}
