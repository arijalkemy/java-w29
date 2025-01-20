package com.example.carDealership.repository;

import com.example.carDealership.dto.VehicleDto;
import com.example.carDealership.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    public Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> geAllVehicles();
    List<Vehicle> geAllVehiclesByPrice(Double since, Double to);
    Optional<Vehicle> findVehicle(Long id);
}
