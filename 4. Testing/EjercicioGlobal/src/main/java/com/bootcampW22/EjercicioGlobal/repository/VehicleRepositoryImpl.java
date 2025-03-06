package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();
    private final Environment environment;

    public VehicleRepositoryImpl(Environment environment) throws IOException {
        this.environment = environment;
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public List<Vehicle> findVehiclesByYearAndColor( String color,int year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getYear() == year && vehicle.getColor().equalsIgnoreCase(color))
                .toList();
    }

    @Override
    public List<Vehicle> findVehiclesByBrandAndRangeOfYear(String brand, int start_year, int end_year) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand)&& v.getYear()>=start_year && v.getYear()<=end_year)
                .toList();
    }

    @Override
    public List<Vehicle> findVehiclesByBrand(String brand) {
        return listOfVehicles.stream().
                filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    @Override
    public List<Vehicle> findVehiclesByRangeOfWeight(double weight_min, double weight_max) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight()>= weight_min && vehicle.getWeight()<= weight_max)
                .toList();
    }


    private void loadDataBase() throws IOException {
        File file;

        if (isTestEnvironment()) {
            file = new File("src/test/resources/vehicles_100.json");
        } else {
            file = ResourceUtils.getFile("classpath:vehicles_100.json");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        listOfVehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {});
    }

    private boolean isTestEnvironment() {
        return environment.getActiveProfiles().length > 0 &&
                environment.getActiveProfiles()[0].equals("test");
    }
}
