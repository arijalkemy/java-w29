package com.example.concesionaria.repositories;

import com.example.concesionaria.entities.Vehiculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VehiculosRepository {
    void add(Vehiculo vehiculo);

    List<Vehiculo> findAll();

    Optional<Vehiculo> findById(Long id);

    List<Vehiculo> findByPrices(Integer minimo, Integer maximo);

    List<Vehiculo> findByDates(Date desde, Date hasta);
}
