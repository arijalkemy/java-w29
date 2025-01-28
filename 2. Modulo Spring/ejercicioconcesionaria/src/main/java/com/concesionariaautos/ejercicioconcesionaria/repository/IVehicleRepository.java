package com.concesionariaautos.ejercicioconcesionaria.repository;

import com.concesionariaautos.ejercicioconcesionaria.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    Optional<Vehicle> findById(Long id);

    Vehicle addVehicle(Vehicle vehicle);

    List<Vehicle> findAll();

    List<Vehicle> findBySinceToDate(String since, String to);

    List<Vehicle> findBySinceToPrice(String since, String to);
}
