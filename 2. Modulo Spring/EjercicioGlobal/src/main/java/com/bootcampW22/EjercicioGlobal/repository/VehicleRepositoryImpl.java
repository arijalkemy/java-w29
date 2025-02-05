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

    private List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();

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
    public Vehicle saveVehicule(VehicleDto vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setRegistration(vehicleDTO.getRegistration());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setMax_speed(vehicleDTO.getMax_speed());
        vehicle.setPassengers(vehicleDTO.getPassengers());
        vehicle.setFuel_type(vehicleDTO.getFuel_type());
        vehicle.setTransmission(vehicleDTO.getTransmission());
        vehicle.setHeight(vehicleDTO.getHeight());
        vehicle.setWidth(vehicleDTO.getWidth());
        vehicle.setWeight(vehicleDTO.getWeight());

        listOfVehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(Long id){
        return listOfVehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().orElse(null);
    };

    @Override
    public void deleteById(Long id) {
        listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }
}
