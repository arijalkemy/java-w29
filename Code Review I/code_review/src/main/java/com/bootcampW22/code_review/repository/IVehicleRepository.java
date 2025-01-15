package com.bootcampW22.code_review.repository;

import com.bootcampW22.code_review.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
}
