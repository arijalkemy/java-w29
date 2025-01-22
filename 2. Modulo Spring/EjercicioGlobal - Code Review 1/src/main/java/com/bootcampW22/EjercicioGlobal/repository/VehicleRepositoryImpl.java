package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public List<Vehicle> save(Vehicle vehicle) {
         listOfVehicles.add(vehicle);
         return listOfVehicles;
    }

    @Override
    public boolean existById(Long id) {
        return listOfVehicles.stream().anyMatch(v -> v.getId().equals(id));
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equals(brand))
                .toList();
    }

    @Override
    public Vehicle updateSpeed(Long id, Double speed) {
        return listOfVehicles.stream()
                .filter( v -> v.getId().equals(id))
                .findFirst()
                .map(v -> {
                    v.setMax_speed(speed);
                    return v;
                }).get();
    }

    @Override
    public List<Vehicle> findByFuel(String type) {
        return listOfVehicles.stream()
                .filter(v -> v.getFuel_type().equals(type))
                .toList();
    }

    @Override
    public List<Vehicle> findByTransmission(String type) {
        return listOfVehicles.stream()
                .filter(v -> v.getTransmission().equals(type))
                .toList();
    }

    @Override
    public Vehicle updateFuel(Long id, String fuel) {
        return listOfVehicles.stream()
                .filter( v -> v.getId().equals(id))
                .findFirst()
                .map(v -> {
                    v.setFuel_type(fuel);
                    return v;
                }).get();
    }

    @Override
    public List<Vehicle> vehiclesByDimension(Integer minL, Integer maxL, Integer maxW, Integer minW) {
        return listOfVehicles.stream()
                .filter(v -> v.getHeight() >= minL && v.getHeight()<=maxL)
                .filter(v -> v.getWidth() >= minW && v.getWidth()<=maxW)
                .toList();
    }

    @Override
    public List<Vehicle> vehiclesByWeight(Integer minW, Integer maxW) {
        return listOfVehicles.stream()
                .filter(v -> v.getWeight() >= minW && v.getWeight()<=maxW)
                .toList();
    }

    @Override
    public Boolean delete(Long id) {
        return listOfVehicles.removeIf(v -> v.getId().equals(id));
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
