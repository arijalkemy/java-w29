package org.melibootcamp.concesionario.repository;

import org.melibootcamp.concesionario.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> vehicles;


    public VehicleRepositoryImpl(){
        vehicles = new ArrayList<>();
    }


    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        Integer id = nextId();
        vehicle.setId(id);
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public List<Vehicle> getAllVehiclesByDate(LocalDate since, LocalDate to) {
        return vehicles
                .stream()
                .filter(
                    vehicle ->
                            (vehicle.getManufacturingDate().isEqual(since) || vehicle.getManufacturingDate().isAfter(since)) &&
                            (vehicle.getManufacturingDate().isEqual(to) || vehicle.getManufacturingDate().isBefore(to))
                )
                .toList();
    }

    @Override
    public List<Vehicle> getAllVehiclesByPrices(Double since, Double to) {
        return vehicles
                .stream()
                .filter(
                        vehicle ->
                                vehicle.getPrice() >= since &&
                                vehicle.getPrice() <= to
                )
                .toList();
    }

    @Override
    public Optional<Vehicle> findVehicleById(Integer id) {
        return vehicles
                .stream()
                .filter(
                        vehicle ->
                                vehicle.getId().equals(id)
                )
                .findFirst();
    }

    private Integer nextId(){
        return vehicles.size() + 1;
    }
}
