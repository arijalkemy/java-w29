package com.mercadolibre.javawave29.concesionaria_de_autos.respository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.javawave29.concesionaria_de_autos.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDealerRepository implements IRepository{

    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Vehicle> vehicles;

    public CarDealerRepository () {
//        vehicles = new ArrayList<>();
        loadVehicles();
    }

    private void loadVehicles() {
        try (InputStream inputStream = getClass().getResourceAsStream("/vehicles.json")) {
            if (inputStream == null) {
                throw new RuntimeException("El archivo JSON no se pudo encontrar en el classpath.");
            }
            vehicles = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar el archivo JSON", e);
        }
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicles
                .stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean addVehicle(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }
}
