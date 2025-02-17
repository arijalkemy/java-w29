package com.api.concesionaria.repository;

import com.api.concesionaria.entity.Vehicle;
import java.util.List;

public interface VehicleRepository {
    void save(Vehicle vehicle);

    List<Vehicle> findAll();

    Vehicle findById(String id);

    List<Vehicle> findByManufacturingDateRange(String since, String to);

    List<Vehicle> findByPriceRange(double since, double to);
}
