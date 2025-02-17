package com.meli.segurovehiculos.service.vehicle;


import com.meli.segurovehiculos.dto.VehicleDto;
import com.meli.segurovehiculos.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public List<VehicleDto> getAllVehicles() {
        return this.vehicleRepository.findAll().stream().map(
                v -> VehicleDto.builder()
                        .vehicleId(v.getVehicleId())
                        .plate(v.getPlate())
                        .brand(v.getBrand())
                        .type(v.getType())
                        .year(v.getYear())
                        .accidents(v.getAccidents())
                        .build()
        ).toList();
    }

    @Override
    public List<String> getAllPlatesVehicles() {
        return this.vehicleRepository.findAllLicensePlates();
    }

    @Override
    public List<Object[]> getAllYears() {
        return this.vehicleRepository.findAllYears();
    }

    @Override
    public List<Object[]> getAllYearsWithWheels(int year) {
        return this.vehicleRepository.findAllYearsWithWheels(year);
    }
}
