package com.example.concesionaria.services;

import com.example.concesionaria.entities.Vehiculo;
import com.example.concesionaria.exceptions.NotFoundException;
import com.example.concesionaria.repositories.VehiculosRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculosServiceImpl implements VehiculosService {

    private final VehiculosRepositoryImpl repo;

    @Override
    public Vehiculo add(Vehiculo vehiculo) {
        repo.add(vehiculo);
        return vehiculo;
    }

    @Override
    public List<Vehiculo> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Vehiculo> getByDate(Date desde, Date hasta) {
        return repo.findByDates(desde, hasta);
    }

    @Override
    public List<Vehiculo> getByPrice(Integer minimo, Integer maximo) {
        return repo.findByPrices(minimo, maximo);
    }

    @Override
    public Vehiculo getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("No existe el vehículo ID " + id));
    }

}
