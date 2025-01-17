package org.example.ej_concesionaria_autos.Repositories;

import org.example.ej_concesionaria_autos.Entities.Vehiculo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class VehiculoRepositoryImpl implements VehiculoRepository {

    List<Vehiculo> vehiculos;


    public VehiculoRepositoryImpl() {
        this.vehiculos = new ArrayList<>();
    }

    @Override
    public Vehiculo addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        return vehiculo;
    }

    @Override
    public List<Vehiculo> getAll() {
        return vehiculos;
    }

    @Override
    public Optional<Vehiculo> findVehiculoById(Integer id) {
        return vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getId().equals(id))
                .findFirst();

    }

    @Override
    public List<Vehiculo> findVehiculoByDate(Date dateSince, Date dateTo) {
        return vehiculos.stream()
                .filter(v -> !v.getManufacturingDate().before(dateSince) && !v.getManufacturingDate().after(dateTo))
                .toList();
    }

    @Override
    public List<Vehiculo> findVehiculoByPrice(Integer priceSince, Integer priceTo) {
        return vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getPrice().compareTo(priceSince) > 0 && vehiculo.getPrice().compareTo(priceTo) < 0)
                .toList();
    }


}
