package com.bootcamp.cardealership.repository;

import com.bootcamp.cardealership.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class VehicleRepository implements IVehicleRepository {

    List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public boolean existsById(String id) {
        return vehicles.stream().anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public Optional<Vehicle> findById(String id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
    }

    @Override
    public Vehicle saveCar(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setId(UUID.randomUUID().toString());
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() {
        return List.copyOf(vehicles);
    }

    @Override
    public Collection<Vehicle> findBetweenDates(LocalDate from, LocalDate to) {
        return vehicles
                .stream()
                .filter(v -> LocalDate.parse(v.getManufacturingDate()).isAfter(from))
                .filter(v -> LocalDate.parse(v.getManufacturingDate()).isBefore(to))
                .toList();
    }

    @Override
    public List<Vehicle> findBetweenPrices(Double from, Double to) {
        return vehicles
                .stream()
                .filter(v -> Double.parseDouble(v.getPrice()) >= from)
                .filter(v -> Double.parseDouble(v.getPrice()) <= to)
                .toList();
    }
}
