package com.example.concesionaria_autos.repository;

import com.example.concesionaria_autos.dto.response.VehiculoWServicesDTO;
import com.example.concesionaria_autos.entity.Vehiculo;

import java.util.Optional;
import java.util.List;

public interface IVehiculoRepository {
    Optional<Vehiculo> getById(Long id);
    Boolean addVehiculo(Vehiculo v);

    Optional<List<Vehiculo>> findVehicles();

    Optional<List<Vehiculo>> findVehiclesbyYearRange(Integer since, Integer to);

    Optional<List<Vehiculo>> findVehiclesbyPriceRange(Integer since, Integer to);

    Optional<Vehiculo> findVehicleByID(Long id);
}
