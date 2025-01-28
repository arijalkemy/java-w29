package com.example.concesionaria.repositories;

import com.example.concesionaria.entities.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VehiculosRepositoryImpl implements VehiculosRepository {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public void add(Vehiculo vehiculo) {
        vehiculo.setId((long) vehiculos.size() + 1);
        vehiculos.add(vehiculo);
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculos;
    }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return vehiculos.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Vehiculo> findByPrices(Integer minimo, Integer maximo) {
        return vehiculos.stream()
                .filter(v -> v.getPrice() <= maximo && v.getPrice() >= minimo)
                .toList();
    }

    @Override
    public List<Vehiculo> findByDates(Date desde, Date hasta) {
        return vehiculos.stream()
                .filter(v -> v.getManufacturingDate().compareTo(desde) > 0 && v.getManufacturingDate()
                        .compareTo(hasta) < 0)
                .toList();
    }
}
