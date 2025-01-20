package org.melibootcamp.concesionario.repository;

import org.melibootcamp.concesionario.entity.Vehicle;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IVehicleRepository {

    Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    List<Vehicle> getAllVehiclesByDate(LocalDate since, LocalDate to);

    List<Vehicle> getAllVehiclesByPrices(Double since, Double to);

    Optional<Vehicle> findVehicleById(Integer id);
}
