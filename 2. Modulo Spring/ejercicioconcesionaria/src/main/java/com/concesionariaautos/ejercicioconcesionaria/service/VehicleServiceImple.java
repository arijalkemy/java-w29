package com.concesionariaautos.ejercicioconcesionaria.service;

import com.concesionariaautos.ejercicioconcesionaria.dto.request.VehicleRequestDto;
import com.concesionariaautos.ejercicioconcesionaria.dto.response.VehicleResponseDto;
import com.concesionariaautos.ejercicioconcesionaria.entity.ServiceVehicle;
import com.concesionariaautos.ejercicioconcesionaria.entity.Vehicle;
import com.concesionariaautos.ejercicioconcesionaria.exception.ConflictException;
import com.concesionariaautos.ejercicioconcesionaria.exception.NotFoundException;
import com.concesionariaautos.ejercicioconcesionaria.repository.IVehicleRepository;
import com.concesionariaautos.ejercicioconcesionaria.repository.VehicleRepositoryImple;
import com.concesionariaautos.ejercicioconcesionaria.utils.MessageExceptions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImple implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImple(VehicleRepositoryImple vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleResponseDto addVehicle(VehicleRequestDto vehicleRequestDto) {
        if (vehicleRepository.findById(vehicleRequestDto.getId()).isPresent()){
            throw new ConflictException(MessageExceptions.VEHICLE_EXIST + vehicleRequestDto.getId());
        }

        Vehicle vehicle = createVehicleCommon(vehicleRequestDto);
        vehicleRepository.addVehicle(vehicle);
        return buildVehicleResponseDto(vehicle);
    }

    @Override
    public List<VehicleResponseDto> findListVehicles() {
        List<Vehicle> vehicleListFound = vehicleRepository.findAll();

        return vehicleListFound.stream()
                .map(this::buildVehicleResponseDto) // Convierte cada Vehicle a VehicleResponseDto
                .toList(); // Convierte el stream en una lista
    }

    @Override
    public List<VehicleResponseDto> findListVehiclesForDateBuild(String since, String to) {
        List<Vehicle> vehicleListFound = vehicleRepository.findBySinceToDate(since, to);
        return vehicleListFound.stream()
                .map(this::buildVehicleResponseDto) // Convierte cada Vehicle a VehicleResponseDto
                .toList(); // Convierte el stream en una lista
    }

    @Override
    public List<VehicleResponseDto> findListVehiclesForForPrices(String since, String to) {
            List<Vehicle> vehicleListFound = vehicleRepository.findBySinceToPrice(since, to);
        return vehicleListFound
                .stream()
                .map(this::buildVehicleResponseDto)
                .toList();
    }

    @Override
    public VehicleResponseDto findVehicle(Long id) {
        Optional<Vehicle> vehicleFound = vehicleRepository.findById(id);
        if (vehicleFound.isEmpty()){
            throw new NotFoundException(MessageExceptions.NOT_FOUND_VEHICLE);
        }
        return buildVehicleResponseDto(vehicleFound.get());
    }

    private VehicleResponseDto buildVehicleResponseDto(Vehicle vehicle) {

        return VehicleResponseDto.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufacturingDate(String.valueOf(vehicle.getManufacturingDate()))
                .numberOfKilometers(vehicle.getNumberOfKilometers())
                .doors(vehicle.getDoors())
                .price(vehicle.getPrice())
                .currency(vehicle.getCurrency())
                .serviceVehicleList(vehicle.getServiceVehicleList())
                .countOfOwners(vehicle.getCountOfOwners())
                .build();
    }

    private Vehicle createVehicleCommon(VehicleRequestDto vehicleRequestDto) {

        return Vehicle.builder()
                .id(vehicleRequestDto.getId())
                .brand(vehicleRequestDto.getBrand())
                .model(vehicleRequestDto.getModel())
                .manufacturingDate(LocalDate.parse(vehicleRequestDto.getManufacturingDate()))
                .numberOfKilometers(vehicleRequestDto.getNumberOfKilometers())
                .doors(vehicleRequestDto.getDoors())
                .price(vehicleRequestDto.getPrice())
                .currency(vehicleRequestDto.getCurrency())
                .serviceVehicleList(vehicleRequestDto.getServiceVehicleList())
                .countOfOwners(vehicleRequestDto.getCountOfOwners())
                .build();
    }

}
