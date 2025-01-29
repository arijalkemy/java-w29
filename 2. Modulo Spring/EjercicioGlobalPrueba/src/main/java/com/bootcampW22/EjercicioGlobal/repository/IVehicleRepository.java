package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void addVehicle(Vehicle vehicle);
    void addBatch(List<Vehicle> vehicles);
    public Vehicle findById(Long id);
    public void editVehicle(Vehicle vehicle);
    List<Vehicle> getFuelType(String type);
    void deleteVehicle(Long id);
    List<Vehicle> dimensionVehicle(Double min_length, Double max_length, Double min_width, Double max_width);
}
