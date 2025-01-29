package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getByColorYear(String color, Integer year);
    Integer getVelocityByBrand( String brand);
    List<Vehicle> addBatchVehicles(List<Vehicle> vehicles);
    void updateSpeed(Long id, String speed);
    List<Vehicle> getFuelType(String type);
    void deleteVehicle(Long id);
    List<VehicleDto> dimensionVehicle(String lengrh, String width);
}
