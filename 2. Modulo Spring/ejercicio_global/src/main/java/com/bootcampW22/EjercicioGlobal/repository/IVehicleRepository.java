package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Optional<Vehicle> findById(Long id);

    Vehicle save(Vehicle vehicule);

    List<Vehicle> findAllByColorAndYear(String color, Integer year);

    List<Vehicle> findAllByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);

    List<Vehicle> findAllByDimensions(Double minHeight, Double maxHeight, Double minWidth, Double maxWidth);

    List<Vehicle> findAllByWeight(Double min, Double max);
}
