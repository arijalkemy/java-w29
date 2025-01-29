package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    ResponseDto addVehicles(VehicleDto vehicle);

    List<VehicleDto> searchVehiclesByBrandAndYears(String brand, int startYears, int endYears);

    AverageSpeedDto averageSpeedByBrand(String brand);

    ResponseDto addBatchVehicles(List<VehicleDto> vehicles);

    ResponseDto updateSpeed(Long id, String speed);

    List<VehicleDto> getVehiclesByFuel(String type);

    ResponseDto deleteVehicle(Long id);

    List<VehicleDto> getVehiclesByTransmission(String type);

    ResponseDto updateFuel(Long id, String fuel);

    AverageCapacityDto averageCapacityByBrand(String brand);

    List<VehicleDto> getVehiclesByDimensions(String length, String width);

    List<VehicleDto> getVehiclesByWeight(Integer minWeight, Integer maxWeight);
}