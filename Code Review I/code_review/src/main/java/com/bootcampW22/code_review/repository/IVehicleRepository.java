package com.bootcampW22.code_review.repository;

import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Optional<Vehicle> getById(Long id);

    void addVehicle(Vehicle newVehicle);
}
