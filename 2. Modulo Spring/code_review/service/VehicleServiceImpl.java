package org.example.code_review.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.example.code_review.dto.VehicleDto;
import org.example.code_review.dto.VehicleInsertResponse;
import org.example.code_review.entity.Vehicle;
import org.example.code_review.exception.NotFoundException;
import org.example.code_review.repository.IVehicleRepository;
import org.example.code_review.repository.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public VehicleDto addVehicle(Vehicle v) {
        if(v.getId() == null){
            throw new IllegalArgumentException("Id is required");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(this.vehicleRepository.create(v), VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getByColorAndYear(String color, Integer year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findByColorAndYear(color, year);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún auto en el sistema con color y año: " + color + " " + year);
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.getByBrandAndBetweenYears(brand, startYear, endYear);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún auto en el sistema con marca entre los años: " + brand + " | [" + startYear + " - " + endYear + "]");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public Double getAverageByBrand(String brand) {
        Double r = this.vehicleRepository.getAverageSpeedByBrand(brand);
        if(r.equals(0.0)){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        return r;
    }

    @Override
    public VehicleInsertResponse addVehicles(List<Vehicle> vehicles) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> inserted =  this.vehicleRepository.createAll(vehicles);

        List<VehicleDto> vehicleDtos =
                inserted.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();

        return new VehicleInsertResponse(vehicleDtos, inserted.size());
    }

    @Override
    public boolean existsVehicleById(Long id) {
        return this.vehicleRepository.existsById(id);
    }

    @Override
    public VehicleDto updateSpeed(Long id, Double newSpeed) {
        ObjectMapper mapper = new ObjectMapper();

        if(newSpeed < 0 ){ throw new IllegalArgumentException("Speed must be positive."); }
        if(!this.existsVehicleById(id)){ throw new NotFoundException("El vehículo con id " + id + " no existe"); }

        return mapper.convertValue(this.vehicleRepository.updateSpeed(id, newSpeed), VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getVehiclesByFuelType(String fuelType) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByFuelType(fuelType);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún auto en el sistema con combustible: " + fuelType);
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public String deleteById(Long id) {
        return this.vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleDto> getVehiclesByTransmission(String type) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesTransmission(type);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún auto en el sistema con combustible: " + type);
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }


    @Override
    public void updateFuelType(Long id, String newFuelType) {

        this.vehicleRepository.updateFuel(id, newFuelType);
    }

    @Override
    public Double getAverageCapacity(String brand) {
        return this.vehicleRepository.findByBrand(brand)
                .stream()
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElse(0);
    }

    @Override
    public List<VehicleDto> getVehiclesByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = this.vehicleRepository.findByDimensions(minHeight, maxHeight, minWidth, maxWidth);

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        return vehicles.stream()
                .map( vehicle -> mapper.convertValue( vehicle , VehicleDto.class))
                .toList();
    }

}
