package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    List<Vehicle> save(Vehicle vehicle);
    List<Vehicle> findByBrand(String brand);
    boolean existById(Long id);
    Vehicle updateSpeed(Long id, String speed);
    List<Vehicle> findByFuel(String type);
    Boolean delete(Long id);
    List<Vehicle> findByTransmission(String type);
    Vehicle updateFuel(Long id, String fuel);
    List<Vehicle> vehiclesByDimension(Integer minL, Integer maxL, Integer maxW, Integer minW);
    List<Vehicle> vehiclesByWeight(Integer minW, Integer maxW);
}
