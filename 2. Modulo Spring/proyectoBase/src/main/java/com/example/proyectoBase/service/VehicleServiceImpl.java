package com.example.proyectoBase.service;

import com.example.proyectoBase.dto.VehicleDto;
import com.example.proyectoBase.entity.Vehicle;
import com.example.proyectoBase.exception.NotFoundException;
import com.example.proyectoBase.exception.VehicleIdAlreadyExistsException;
import com.example.proyectoBase.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private final VehicleRepositoryImpl vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto findVehicleById(Long id) {
        return null;
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        if (vehicleRepository.findById(vehicleDto.getId()) != null) {
            throw new VehicleIdAlreadyExistsException(vehicleDto.getId());
        }
        return map(vehicleRepository.save(map(vehicleDto)));
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public void deleteVehicle(Long id) {
    }

    public List<VehicleDto> map(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::map).collect(Collectors.toList());
    }

    public VehicleDto map(Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getRegistration(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getMax_speed(),
                vehicle.getFuel_type(),
                vehicle.getTransmission(),
                vehicle.getPassengers(),
                vehicle.getHeight(),
                vehicle.getWidth(),
                vehicle.getWeight()
        );
    }

    public Vehicle map(VehicleDto vehicleDto) {
        return new Vehicle(
                vehicleDto.getId(),
                vehicleDto.getBrand(),
                vehicleDto.getModel(),
                vehicleDto.getRegistration(),
                vehicleDto.getYear(),
                vehicleDto.getColor(),
                vehicleDto.getMax_speed(),
                vehicleDto.getFuel_type(),
                vehicleDto.getTransmission(),
                vehicleDto.getPassengers(),
                vehicleDto.getHeight(),
                vehicleDto.getWidth(),
                vehicleDto.getWeight()
        );
    }
}
