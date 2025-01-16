package com.bootcampW22.code_review.repository;

import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Optional<Vehicle> getById(Long id);
    void addVehicle(Vehicle newVehicle);
    List<Vehicle> getByColorAndYear(String color, Integer year);
    List<Vehicle> getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);
    List<Vehicle> getByWeight(double weightMin, double weightMax);
    List<Vehicle> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth);
    void updateFuel(Vehicle entity, String fuelType);
    Double getAverageCapacityByBrand(String brand);
}
