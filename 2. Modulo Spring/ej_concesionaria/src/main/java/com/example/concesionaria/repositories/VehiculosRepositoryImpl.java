package com.example.concesionaria.repositories;

import com.example.concesionaria.entities.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VehiculosRepositoryImpl implements VehiculosRepository {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public void add(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public List<Vehiculo> getAll() {
        return vehiculos;
    }

    @Override
    public Optional<Vehiculo> getById(Integer id) {
        return vehiculos.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    @Override
    public List<Vehiculo> getByPrices(Integer minimo, Integer maximo) {
        return vehiculos.stream().filter(v -> v.getPrice() <= maximo && v.getPrice() >= minimo).toList();
    }

    @Override
    public List<Vehiculo> getByDates(Date desde, Date hasta) {
        return vehiculos.stream().filter(v -> v.getManufacturingDate().compareTo(desde) > 0 && v.getManufacturingDate().compareTo(hasta) < 0).toList();
    }
}
