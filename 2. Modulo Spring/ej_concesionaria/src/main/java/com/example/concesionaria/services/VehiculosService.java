package com.example.concesionaria.services;

import com.example.concesionaria.entities.Vehiculo;

import java.util.Date;
import java.util.List;

public interface VehiculosService {

    Vehiculo add(Vehiculo vehiculo);

    List<Vehiculo> getAll();

    List<Vehiculo> getByDate(Date desde, Date hasta);

    List<Vehiculo> getByPrice(Integer minimo, Integer maximo);

    Vehiculo getById(Long id);

}
