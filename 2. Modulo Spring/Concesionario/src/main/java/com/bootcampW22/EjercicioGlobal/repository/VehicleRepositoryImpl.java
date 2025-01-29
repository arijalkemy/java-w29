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
    @Override
    public boolean findOnlyById(Long id) {
        return listOfVehicles.stream()
                .anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public void save(Vehicle newVehicle) {
        listOfVehicles.add(newVehicle);
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, int year) {
        ObjectMapper objectMapper = new ObjectMapper();
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByBrandAndDates(String brand, int startYear, int endYear) {
        ObjectMapper objectMapper = new ObjectMapper();
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand)&&vehicle.getYear()>=startYear&&vehicle.getYear()<=endYear)
                .map(vehicle -> objectMapper.convertValue(vehicle,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public void updateVehicleSpeed(Long id, String speed) {
        Vehicle vehi = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst().orElse(null);
        vehi.setMax_speed(speed);
    }

    @Override
    public List<VehicleDto> searchByFuelType(String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type))
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeVehicle(Long id) {
        listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public List<VehicleDto> searchByTransmissionType(String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(type))
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public void updateVehicleFuel(Long id, String fuel) {
        Vehicle vehicle = listOfVehicles.stream()
                .filter(vehi -> vehi.getId().equals(id))
                .findFirst().orElse(null);
        vehicle.setFuel_type(fuel);
    }

    @Override
    public List<VehicleDto> searchByDimensions(Double minLengths, Double maxLengths, Double minWidth, Double maxWidth) {
        ObjectMapper objectMapper = new ObjectMapper();
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getHeight() >= minLengths && vehicle.getHeight() <= maxLengths)
                .filter(vehicle -> vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByWeight(Double min, Double max) {
        ObjectMapper objectMapper = new ObjectMapper();
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight()>=min&&vehicle.getWeight()<=max)
                .map(vehicle -> objectMapper.convertValue(vehicle,VehicleDto.class))
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
