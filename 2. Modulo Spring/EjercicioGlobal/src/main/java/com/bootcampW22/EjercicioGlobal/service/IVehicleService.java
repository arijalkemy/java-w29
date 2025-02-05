package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.time.Year;
import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    List<Vehicle> SearchByColorYear(String color, Integer year);
    List<Vehicle> findByYearBrand(Integer startYear, Integer endYear, String brand);
    Double averageSpeedBrand(String brand);
    String saveVehicles(List<VehicleDto> vehicleDTOs);
    String saveVehicle(VehicleDto vehicleDto);
    String updateSpeedVehicle(Integer newSpeed, Long id);
    List<Vehicle> findByFuelType(String fuelType);
    String deleteById(Long id);
    List<Vehicle> findByTransmission(String transmission);
    String updateFuelType(String fuelType, Long id);
    Double averageCapacity(String brand);
    List<Vehicle> findByDimentions(Double minWidth, Double minHeight,Double MaxWidth, Double MaxHeight);
    List<Vehicle> findByWeigth(Double minWeight, Double MaxWeight);
}
