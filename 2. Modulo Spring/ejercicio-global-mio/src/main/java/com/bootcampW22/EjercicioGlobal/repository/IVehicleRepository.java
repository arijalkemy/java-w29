package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void addVehicle(Vehicle vehicle);
    Vehicle findById(Long id);
    Integer getVehicleIndex(Long id);
    void updateVehicle(Integer index, Vehicle vehicle);

    Vehicle findByIndex(int index);

    Vehicle deleteVehicle(int index);
}
