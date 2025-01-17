package org.example.ej_concesionaria_autos.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ej_concesionaria_autos.Dtos.VehiculoDTO;
import org.example.ej_concesionaria_autos.Entities.Vehiculo;
import org.example.ej_concesionaria_autos.Exceptions.NoFoundException;
import org.example.ej_concesionaria_autos.Repositories.VehiculoRepositoryImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    private final VehiculoRepositoryImpl repository;
    private Integer maxId = 1;

    public VehiculoServiceImpl(VehiculoRepositoryImpl repository) {
        this.repository = repository;
    }


    @Override
    public Vehiculo add(VehiculoDTO vehiculoDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Vehiculo vehiculo = mapper.convertValue(vehiculoDTO, Vehiculo.class);
        vehiculo.setId(maxId++);
        return repository.addVehiculo(vehiculo);
    }

    @Override
    public List<VehiculoDTO> getAll() {
        List<Vehiculo> vehiculos = repository.getAll();
        ObjectMapper mapper = new ObjectMapper();
        return vehiculos.stream()
                .map(v -> mapper.convertValue(v, VehiculoDTO.class))
                .toList();
    }


    @Override
    public Optional<VehiculoDTO> getVehiculoById(Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Vehiculo> vehiculo = repository.findVehiculoById(id);
        if (vehiculo.isEmpty()) {
            throw new NoFoundException("Usuario no encontrado con el id:" + id);
        }
        return vehiculo.map(v -> mapper.convertValue(v, VehiculoDTO.class));
    }


    @Override
    public List<VehiculoDTO> getVehiculoByPrice(Integer priceSince, Integer princeTo) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehiculo> vehiculos = repository.findVehiculoByPrice(priceSince, princeTo);
        if (vehiculos.isEmpty()) {
            throw new NoFoundException("No hay vehiculos por el rango de precio de :" + priceSince + " a " + princeTo);
        }
        return vehiculos.stream()
                .map(v -> mapper.convertValue(v, VehiculoDTO.class))
                .toList();

    }

    @Override
    public List<VehiculoDTO> getVehiculoByDate(Date dateSince, Date dateTo) {
        ObjectMapper mapper = new ObjectMapper();

        List<Vehiculo> vehiculos = repository.findVehiculoByDate(dateSince, dateTo);

        if (vehiculos.isEmpty()) {
            throw new NoFoundException("No hay vehículos por el rango de fecha de: " + dateSince + " a " + dateTo);
        }

        return vehiculos.stream()
                .map(v -> mapper.convertValue(v, VehiculoDTO.class))
                .toList();

    }
}
