package com.example.proyectoBase.repository;

import com.example.proyectoBase.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle findById(Long id);
    Vehicle save(Vehicle vehicle);
    void delete(Vehicle vehicle);
}
