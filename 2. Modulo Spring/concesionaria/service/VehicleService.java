package com.api.concesionaria.service;



import com.api.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VehicleService {
    void addVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(String id);

    List<Vehicle> getVehiclesByDateRange(String since, String to);

    List<Vehicle> getVehiclesByPriceRange(double since, double to);
}
