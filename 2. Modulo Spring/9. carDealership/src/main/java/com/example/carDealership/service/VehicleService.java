package com.example.carDealership.service;

import com.example.carDealership.dto.VehicleDto;
import com.example.carDealership.entity.Vehicle;
import com.example.carDealership.exceptions.CreatingError;
import com.example.carDealership.exceptions.NotFoundException;
import com.example.carDealership.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehiclesService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDto addNewVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = vehicleRepository.addVehicle(mapper.convertValue(vehicleDto, Vehicle.class));
        if (vehicle == null) {
            throw new CreatingError("Error creando el vehículo");
        }
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.geAllVehicles();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos");
        }
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> geAllVehiclesByManufacturingDate(String startDate, String endDate) {
        ObjectMapper mapper = new ObjectMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate parseStartDate = LocalDate.parse(startDate, formatter);
        LocalDate parseEndDate = LocalDate.parse(endDate, formatter);
        List<Vehicle> vehicles = vehicleRepository.geAllVehicles().stream()
                .filter(v -> {
                    LocalDate date = LocalDate.parse(v.getManufacturingDate(), formatter);
                    return date.isAfter(parseStartDate) && date.isBefore(parseEndDate);
                })
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos");
        }
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> geAllVehiclesByPrice(Double since, Double to) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.geAllVehiclesByPrice(since, to);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos");
        }
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public VehicleDto findVehicle(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Vehicle> vehicle = vehicleRepository.findVehicle(id);
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos");
        }

        return mapper.convertValue(vehicle.get(), VehicleDto.class);
    }
}
