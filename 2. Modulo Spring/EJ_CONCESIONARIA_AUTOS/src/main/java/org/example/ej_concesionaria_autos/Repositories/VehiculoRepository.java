package org.example.ej_concesionaria_autos.Repositories;

import org.example.ej_concesionaria_autos.Entities.Vehiculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VehiculoRepository {

    Vehiculo addVehiculo(Vehiculo vehiculo);

    List<Vehiculo> getAll();

    Optional<Vehiculo> findVehiculoById(Integer id);

    List<Vehiculo> findVehiculoByDate(Date dateSince, Date dateTo);

    List<Vehiculo> findVehiculoByPrice(Integer priceSince, Integer priceTo);
}
