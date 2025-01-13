package com.example.concesionaria.services;

import com.example.concesionaria.entities.Vehiculo;
import com.example.concesionaria.exceptions.NotFoundException;
import com.example.concesionaria.repositories.VehiculosRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculosServiceImpl implements VehiculosService {

    private final VehiculosRepositoryImpl repo;

    private Long maxId = 1L;

    @Override
    public Vehiculo add(Vehiculo vehiculo) {
        vehiculo.setId(maxId++);
        repo.add(vehiculo);
        return vehiculo;
    }

    @Override
    public List<Vehiculo> getAll() {
        return repo.getAll();
    }

    @Override
    public List<Vehiculo> getByDate(Date desde, Date hasta) {
        return repo.getByDates(desde, hasta);
    }

    @Override
    public List<Vehiculo> getByPrice(Integer minimo, Integer maximo) {
        return repo.getByPrices(minimo, maximo);
    }

    @Override
    public Vehiculo getById(Integer id) {
        Optional<Vehiculo> optionalVehiculo = repo.getById(id);
        if (optionalVehiculo.isEmpty()) throw new NotFoundException("No existe el vehículo ID " + id);
        return optionalVehiculo.get();
    }

}
