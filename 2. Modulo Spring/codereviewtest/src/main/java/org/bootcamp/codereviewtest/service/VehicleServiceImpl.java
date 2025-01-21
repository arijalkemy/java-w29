package org.bootcamp.codereviewtest.service;

import org.bootcamp.codereviewtest.dto.VehicleDto;
import org.bootcamp.codereviewtest.entity.Vehicle;
import org.bootcamp.codereviewtest.exception.NotFoundException;
import org.bootcamp.codereviewtest.repository.IVehicleRepository;
import org.bootcamp.codereviewtest.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        List<Vehicle> vehiclesFound = vehicleRepository.findByBrandAndBetweenYears(brand, startYear, endYear);

        if (vehiclesFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        ObjectMapper ob = new ObjectMapper();

        return vehiclesFound.stream().map(v -> ob.convertValue(v, VehicleDto.class)).toList();
    }
}
