package com.thiagoschreck.local.ej_concensionaria_autos.repository;

import com.thiagoschreck.local.ej_concensionaria_autos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    List<Vehicle> find();
    List<Vehicle> find(String fromDate, String toDate);
}
