package com.example.carDealership.repository;

import com.example.carDealership.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository implements IVehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Long countId = 1L;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicle.setId(countId);
        countId++;
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> geAllVehicles() {
        return vehicles;
    }

    @Override
    public List<Vehicle> geAllVehiclesByPrice(Double since, Double to) {
        return vehicles.stream()
                .filter(v -> Double.parseDouble(v.getPrice()) >= since && Double.parseDouble(v.getPrice()) <= to)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vehicle> findVehicle(Long id) {
        return vehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
    }
}
