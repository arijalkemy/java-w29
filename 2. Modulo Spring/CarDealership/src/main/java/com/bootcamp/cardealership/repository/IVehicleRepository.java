package com.bootcamp.cardealership.repository;

import com.bootcamp.cardealership.model.Vehicle;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface IVehicleRepository {
    boolean existsById(String id);
    Optional<Vehicle> findById(String id);
    Vehicle saveCar(Vehicle vehicle);
    Collection<Vehicle> findAll();

    Collection<Vehicle> findBetweenDates(LocalDate from, LocalDate to);

    Collection<Vehicle> findBetweenPrices(Double from, Double to);
}
