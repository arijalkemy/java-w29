package com.example.proyectoBase.repository;

import com.example.proyectoBase.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private final List<Vehicle> listOfVehicles = getInitialVehiclesData();

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle findById(Long vehicleId) {
        System.out.println(listOfVehicles.stream().findFirst().orElse(null));
        return listOfVehicles.stream().findFirst().orElse(null);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return null;
    }

    @Override
    public void delete(Vehicle vehicle) {

    }

    private List<Vehicle> getInitialVehiclesData() {
        try {
            final File jsonFile = new ClassPathResource("vehicles_100.json").getFile();
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
