package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle addVehicle(Vehicle vehicle);

    Optional<Vehicle> findVehicleById(Long id);

    List<Vehicle> getVehicleByColorAndYear(String color, int year);

    List<Vehicle> getVehicleByBrandAndYears(String brand, int starYear, int endYear);

    Double getAverageSpeedByBrand(String brand);

    List<Vehicle> addAllVehicles(List<Vehicle> vehicles);

    Vehicle updateSpeed(Long id, Double newSpeed);

    List<Vehicle> findVehicleByFuel(String fuel);

    Boolean deleteVehicle(Long id);

    List<Vehicle> findByTrasmissionType(String trasmission);

    Boolean updateFuel(Long id, String fuel);

    List<Vehicle> findByDimensiones(Double minWidth, Double maxWidth, Double minHeight, Double maxHeight);

    Double avgPersonByBrand(String brand);

    List<Vehicle> getVehicleByWeight(Double minWeight, Double maxWeight);
}
