package com.bootcamp.cardealership.service;

import com.bootcamp.cardealership.dto.VehicleDTO;
import com.bootcamp.cardealership.model.Vehicle;
import com.bootcamp.cardealership.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {

    private final VehicleRepository vehicleRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        Vehicle vehicle = objectMapper.convertValue(vehicleDTO, Vehicle.class);
        return objectMapper.convertValue(vehicleRepository.saveCar(vehicle), VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getAll() {
        return vehicleRepository
                .findAll()
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDTO.class))
                .toList();
    }

    @Override
    public List<VehicleDTO> getBetweenDates(LocalDate from, LocalDate to) {
        return vehicleRepository
                .findBetweenDates(from, to)
                .stream()
                .map(v -> objectMapper.convertValue(v, VehicleDTO.class))
                .toList();
    }

    @Override
    public List<VehicleDTO> getBetweenPrices(Double from, Double to) {
        return vehicleRepository
                .findBetweenPrices(from, to)
                .stream()
                .map(v -> objectMapper.convertValue(v, VehicleDTO.class))
                .toList();
    }

    @Override
    public VehicleDTO findById(String id) {
        return vehicleRepository
                .findById(id)
                .map(value -> objectMapper.convertValue(value, VehicleDTO.class))
                .orElse(null);

    }
}
