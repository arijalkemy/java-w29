package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    void addVehicle(Vehicle vehicle);

    List<VehicleDto> searchByColorAndYear(String color, int year);

    List<VehicleDto> searchByBrandAndDates(String brand, int startYear, int endYear);

    AverageSpeedDto calculateAverageSpeedByBrand(String brand);

    void addListOfVehicles(List<VehicleDto> vehicleDtos);

    void updateVehicleSpeed(Long id, String speed);

    List<VehicleDto> searchByFuelType(String type);

    void removeVehicle(Long id);

    List<VehicleDto> searchByTransmission(String type);

    void updateVehicleFuelType(Long id, String fuel);

    Double searchAverageCapacity(String brand);

    List<VehicleDto> searchVehiclesByDimensions(String lengthRange, String widthRange);

    List<VehicleDto> searchVehicleByWeight(Double min, Double max);
}
