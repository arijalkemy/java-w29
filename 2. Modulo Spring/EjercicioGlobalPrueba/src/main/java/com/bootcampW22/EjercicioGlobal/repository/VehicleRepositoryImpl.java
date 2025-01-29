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
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        listOfVehicles.add(vehicle);
    }

    public void addBatch(List<Vehicle> vehicles){
        listOfVehicles.addAll(vehicles);
    }

    public Vehicle findById(Long id){
        Optional<Vehicle> vehicle = listOfVehicles.stream().filter(x-> Objects.equals(x.getId(),id)).findFirst();
        Vehicle vehicle1 = null;
        if(vehicle.isPresent()){
            vehicle1 = vehicle.get();
        }
        return vehicle1;
    }

    public void editVehicle(Vehicle vehicle){
        Vehicle vehicle1 = findById(vehicle.getId());
        listOfVehicles.forEach(vehicle2 -> {
            if (Objects.equals(vehicle2.getId(), vehicle1.getId())) {
                vehicle2 = vehicle1;
            }});
    }

    @Override
    public List<Vehicle> getFuelType(String type) {
        return listOfVehicles.stream().filter(vehicle -> Objects.equals(vehicle.getFuel_type(),type)).toList();
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = findById(id);
        listOfVehicles.remove(vehicle);
    }

    @Override
    public List<Vehicle> dimensionVehicle(Double min_length, Double max_length, Double min_width, Double max_width) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getWidth()<=max_width && vehicle.getWidth() >= min_width && vehicle.getHeight() <= max_length && vehicle.getHeight() >= min_length).toList();
    }
}
