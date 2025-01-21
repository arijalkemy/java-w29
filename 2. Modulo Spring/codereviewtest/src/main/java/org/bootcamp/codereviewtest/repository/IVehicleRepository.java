package org.bootcamp.codereviewtest.repository;

import org.bootcamp.codereviewtest.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    List<Vehicle> findByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);
}
