package com.example.concesionaria.repositories;

import com.example.concesionaria.entities.Vehiculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VehiculosRepository {

    void add(Vehiculo vehiculo);

    List<Vehiculo> getAll();

    Optional<Vehiculo> getById(Integer id);

    List<Vehiculo> getByPrices(Integer minimo, Integer maximo);

    List<Vehiculo> getByDates(Date desde, Date hasta);

}
