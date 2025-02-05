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

    //[US-0001]
    @Override
    public boolean findById(Long id) {
        return listOfVehicles.stream()
                .anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    //[US-0001]//[US-0005]
    @Override
    public void addVehicle(Vehicle vehicle) {
        ObjectMapper objectMapper = new ObjectMapper();
        listOfVehicles.add(objectMapper.convertValue(vehicle, Vehicle.class));
    }

    //[US-0002]
    @Override
    public List<Vehicle> getVehiclesByColorYear(String color, int year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .collect(Collectors.toList());
    }

    //[US-0003]
    @Override
    public List<Vehicle> getVehiclesByCBrandByBeetweenYears(String brand, int startYear, int endYear) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand) && vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .collect(Collectors.toList());
    }

    //[US-0004]
    @Override
    public List<Vehicle> findVehicleByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    //[US-0006]
    @Override
    public void updateMaxSpeedVehicle(Long id, String updateSpeed) {
        Vehicle vehicle = listOfVehicles.stream()
                .filter(vehicle1 -> vehicle1.getId().equals(id))
                .findFirst()
                .orElse(null);
        vehicle.setMax_speed(updateSpeed);
    }

    //[US-0007]
    @Override
    public List<VehicleDto> searchByFuelType(String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type))
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    //[US-0012]
    @Override
    public List<Vehicle> findByDimensions(Double minlength, Double maxlength, Double minwidth, Double maxwidth) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getHeight()>=minlength && vehicle.getHeight()<= maxlength)
                .filter(vehicle -> vehicle.getWidth()>=minwidth && vehicle.getWidth()<= maxwidth)
                .collect(Collectors.toList());
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
