package org.example.code_review.service;


import org.example.code_review.dto.VehicleDto;
import org.example.code_review.dto.VehicleInsertResponse;
import org.example.code_review.entity.Vehicle;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto addVehicle(Vehicle v);
    List<VehicleDto> getByColorAndYear(String color, Integer year);
    List<VehicleDto>  getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);

    Double getAverageByBrand(String brand);

    VehicleInsertResponse addVehicles(List<Vehicle> vehicles);

    boolean existsVehicleById(Long id);

    VehicleDto updateSpeed(Long id, Double newSpeed);

    List<VehicleDto>  getVehiclesByFuelType(String fuelType);

    String deleteById(Long id);

    List<VehicleDto> getVehiclesByTransmission(String type);


    void updateFuelType(Long id, String newFuelType);

    Double getAverageCapacity(String brand);

    List<VehicleDto>  getVehiclesByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth);
}

