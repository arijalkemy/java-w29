package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Optional<Vehicle> findVehicleById(Long id) {
        return listOfVehicles
                .stream().filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Vehicle> getVehicleByColorAndYear(String color, int year) {
        return listOfVehicles.stream().filter(v -> v.getColor().equalsIgnoreCase(color) && v.getYear() == year)
                .toList();
    }

    @Override
    public List<Vehicle> getVehicleByBrandAndYears(String brand, int starYear, int endYear) {
        return listOfVehicles.stream().filter(v -> v.getBrand().equals(brand) && v.getYear() >= starYear && v.getYear() <= endYear)
                .toList();
    }

    @Override
    public Double getAverageSpeedByBrand(String brand) {

        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equals(brand))
                .mapToDouble(value -> Double.parseDouble(value.getMax_speed()))
                .average()
                .orElse(0.0);

    }

    @Override
    public List<Vehicle> addAllVehicles(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
        return vehicles;
    }

    @Override
    public Vehicle updateSpeed(Long id, Double newSpeed) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .map(vehicle -> {
                    vehicle.setMax_speed(String.valueOf(newSpeed));
                    return vehicle;
                })
                .orElse(null);
    }

    @Override
    public List<Vehicle> findVehicleByFuel(String fuel) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equals(fuel))
                .toList();
    }

    @Override
    public Boolean deleteVehicle(Long id) {

        return listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public List<Vehicle> findByTrasmissionType(String trasmission) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equals(trasmission))
                .toList();
    }

    @Override
    public Boolean updateFuel(Long id, String fuel) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .map(vehicle -> {
                    vehicle.setFuel_type(fuel);
                    return  true;
                })
                .orElse(false);
    }

    @Override
    public List<Vehicle> findByDimensiones(Double minWidth, Double maxWidth, Double minHeight, Double maxHeight) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWidth() >= minHeight && vehicle.getHeight() <= maxWidth
                        && vehicle.getHeight() >= minHeight && vehicle.getHeight() <= maxHeight)
                .toList();
    }

    @Override
    public Double avgPersonByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElse(0);


    }

    @Override
    public List<Vehicle> getVehicleByWeight(Double minWeight, Double maxWeight) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWidth() >= minWeight && vehicle.getWeight() <= maxWeight)
                .toList();
    }


    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
        });

        listOfVehicles = vehicles;
    }
}
