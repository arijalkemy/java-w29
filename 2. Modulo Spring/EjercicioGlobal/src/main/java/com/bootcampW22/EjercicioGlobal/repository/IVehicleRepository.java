package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.time.Year;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle saveVehicule(VehicleDto vehicleDTO);
    Vehicle findById(Long id);
    void deleteById(Long id);
}
