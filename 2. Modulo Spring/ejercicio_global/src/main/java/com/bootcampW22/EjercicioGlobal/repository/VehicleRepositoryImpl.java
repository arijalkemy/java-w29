package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;
        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
        });
        listOfVehicles = vehicles;
    }

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return listOfVehicles.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Vehicle save(Vehicle vehicule) {
        listOfVehicles.add(vehicule);
        return vehicule;
    }

    @Override
    public List<Vehicle> findAllByColorAndYear(String color, Integer year) {
        return listOfVehicles.stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color) && v.getYear() == year)
                //.filter(v -> Objects.equals(v.getColor(), color) && Objects.equals(v.getYear(), year))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findAllByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .filter(v -> v.getYear() >= startYear && v.getYear() <= endYear)
                .toList();
    }

    @Override
    public List<Vehicle> findAllByDimensions(Double minHeight, Double maxHeight, Double minWidth, Double maxWidth) {
        return listOfVehicles.stream()
                .filter(v -> v.getHeight() >= minHeight && v.getHeight() <= maxHeight
                        && v.getWidth() >= minWidth && v.getWidth() <= maxWidth)
                .toList();
    }

    @Override
    public List<Vehicle> findAllByWeight(Double min, Double max) {
        return listOfVehicles.stream()
                .filter(v -> v.getWidth() >= min && v.getWidth() <= max)
                .toList();
    }

    @Override
    public Double getAverageCapacityOfBrand(String brand) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(Vehicle::getPassengers)
                .average()
                .orElse(0.0);
    }

    @Override
    public Double getAverageSpeedOfBrand(String brand) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElse(0.0);
    }

    @Override
    public boolean saveAll(List<Vehicle> vehiclesToSave) {
        return listOfVehicles.addAll(vehiclesToSave);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle existingVehicle = listOfVehicles.stream()
                .filter(v -> v.getId().equals(vehicle.getId()))
                .findFirst()
                .orElse(null);
        try {
            new ObjectMapper().updateValue(existingVehicle, vehicle);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }
        return existingVehicle;
    }

    @Override
    public List<Vehicle> findAllByFuelType(String type) {
        return listOfVehicles.stream()
                .filter(v -> v.getFuel_type().equalsIgnoreCase(type))
                .toList();
    }

    @Override
    public void remove(Vehicle vehicle) {
        listOfVehicles.remove(vehicle);
    }

    @Override
    public List<Vehicle> findByTransmissionType(String type) {
        return listOfVehicles.stream()
                .filter(v -> v.getTransmission().equalsIgnoreCase(type))
                .toList();
    }


}
