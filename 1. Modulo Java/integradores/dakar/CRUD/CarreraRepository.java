package com.example.demo.integradores.dakar.CRUD;

import com.example.demo.integradores.dakar.Carrera;
import com.example.demo.integradores.dakar.Vehiculo;

import java.util.*;
import java.util.stream.IntStream;

public class CarreraRepository implements CRUD<Vehiculo> {
    private final Carrera carrera ;

    public CarreraRepository(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void create(Vehiculo entity) {
        this.carrera.getVehiculos().add(entity);
    }

    @Override
    public Optional<Vehiculo> read(String id) {
        return Optional.of((Vehiculo) this.carrera.getVehiculos().stream().filter( (v) -> v.getPatente().equals(id) ));
    }

    @Override
    public void update(String id, Vehiculo entity) {
        OptionalInt indexOpt = IntStream.range(0, carrera.getVehiculos().size())
                .filter(i -> carrera.getVehiculos().get(i).getPatente().equals(id))
                .findFirst();

        if (indexOpt.isPresent()) {
            carrera.getVehiculos().set(indexOpt.getAsInt(), entity);
        } else {
            throw new NoSuchElementException("No se encontró un vehículo con la patente: " + id);
        }
    }
    @Override
    public void delete(String id) {
        carrera.getVehiculos().removeIf(vehiculo -> vehiculo.getPatente().equals(id));
    }

    @Override
    public List<Vehiculo> listAll() {
        return new ArrayList<>(this.carrera.getVehiculos());
    }
}
