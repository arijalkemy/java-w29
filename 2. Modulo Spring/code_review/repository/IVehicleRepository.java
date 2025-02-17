package org.example.code_review.repository;


import org.example.code_review.dto.VehicleDto;
import org.example.code_review.dto.VehicleInsertResponse;
import org.example.code_review.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle create(Vehicle v);
    List<Vehicle> findByColorAndYear(String color, Integer year);
    List<Vehicle> getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);

    Double getAverageSpeedByBrand(String brand);

    List<Vehicle> createAll(List<Vehicle> vehicles);

    boolean existsById(Long id);

    Vehicle updateSpeed(Long id, Double newSpeed);

    List<Vehicle> findVehiclesByFuelType(String fuelType);

    String deleteById(Long id);

    List<Vehicle> findVehiclesTransmission(String type);


    void updateFuel(Long id, String newFuelType);

    List<Vehicle> findByBrand(String brand);

    List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth);
}
