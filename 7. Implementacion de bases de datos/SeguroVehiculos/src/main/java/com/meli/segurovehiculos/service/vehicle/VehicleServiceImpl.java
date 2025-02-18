package com.meli.segurovehiculos.service.vehicle;

import com.meli.segurovehiculos.dto.VehicleDto;
import com.meli.segurovehiculos.model.Vehicle;
import com.meli.segurovehiculos.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public List<VehicleDto> getAllVehicles() {
        return this.vehicleRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public List<VehicleDto> getAllPlatesVehicles() {
        return this.vehicleRepository.findAllLicensePlates().stream().map(this::toDto).toList();
    }

    @Override
    public List<VehicleDto> getAllYears() {
        return this.vehicleRepository.findAllYears().stream().map(this::toDto).toList();
    }

    @Override
    public List<VehicleDto> getAllYearsWithWheels(int year) {
        return this.vehicleRepository.findAllYearsWithWheels(year).stream().map(this::toDto).toList();
    }

    private VehicleDto toDto(Vehicle vehicle) {
        return VehicleDto.builder()
                .vehicleId(vehicle.getVehicleId())
                .plate(vehicle.getPlate())
                .brand(vehicle.getBrand())
                .type(vehicle.getType())
                .year(vehicle.getYear())
                .accidents(vehicle.getAccidents())
                .build();
    }
}
