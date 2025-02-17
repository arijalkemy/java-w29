package com.api.concesionaria.service;


import com.api.concesionaria.entity.Vehicle;
import com.api.concesionaria.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        repository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    @Override
    public Vehicle getVehicleById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Vehicle> getVehiclesByDateRange(String since, String to) {
        return repository.findByManufacturingDateRange(since, to);
    }

    @Override
    public List<Vehicle> getVehiclesByPriceRange(double since, double to) {
        return repository.findByPriceRange(since, to);
    }
}
