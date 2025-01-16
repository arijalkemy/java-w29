package com.api.concesionaria.repository;



import com.api.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    private final List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Vehicle findById(String id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getModel().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Vehicle> findByManufacturingDateRange(String since, String to) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getManufacturingDate().compareTo(since) >= 0
                        && vehicle.getManufacturingDate().compareTo(to) <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByPriceRange(double since, double to) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .collect(Collectors.toList());
    }
}
