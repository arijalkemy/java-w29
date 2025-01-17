package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.CanNotSaveException;
import com.bootcampW22.EjercicioGlobal.exception.DuplicateIdException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
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
    public VehicleDto addOne(VehicleDto dto) {
        if (vehicleRepository.findById(dto.getId()).isPresent()) {
            throw new DuplicateIdException("Identificador del vehículo ya existente");
        }
        ObjectMapper mapper = new ObjectMapper();
        vehicleRepository.save(mapper.convertValue(dto, Vehicle.class));
        return dto;
    }

    @Override
    public List<VehicleDto> findAllByColorAndYear(String color, Integer year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAllByColorAndYear(color, year);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findAllByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        List<Vehicle> vehicleList = vehicleRepository.findAllByBrandAndBetweenYears(brand, startYear, endYear);
        ObjectMapper mapper = new ObjectMapper();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> findAllByDimensions(String height, String width) {
        String[] heightRange = height.split("-");
        String[] widthRange = width.split("-");

        Double minHeight = Double.valueOf(heightRange[0]);
        Double maxHeight = Double.valueOf(heightRange[1]);

        Double minWidth = Double.valueOf(widthRange[0]);
        Double maxWidth = Double.valueOf(widthRange[1]);

        List<Vehicle> vehicleList = vehicleRepository.findAllByDimensions(minHeight, maxHeight, minWidth, maxWidth);
        ObjectMapper mapper = new ObjectMapper();

        if (vehicleList.isEmpty())
            throw new NotFoundException("No se encontraron vehículos con esas dimensoines.");

        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> findAllByWeight(Double min, Double max) {
        List<Vehicle> vehicleList = vehicleRepository.findAllByWeight(min, max);
        ObjectMapper mapper = new ObjectMapper();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese peso.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public Double getAverageCapacityOfBrand(String brand) {
        Double average = vehicleRepository.getAverageCapacityOfBrand(brand);
        if (average == 0.0) {
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        return average;
    }

    @Override
    public Double getAverageSpeedOfBrand(String brand) {
        Double average = vehicleRepository.getAverageSpeedOfBrand(brand);
        if (average == 0.0) {
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        return average;
    }

    @Override
    public List<VehicleDto> addVehicles(List<VehicleDto> dtos) {
        List<Vehicle> createdVehicles = vehicleRepository.findAll();
        boolean isRepited = createdVehicles.stream()
                .anyMatch(entity -> dtos.stream()
                        .anyMatch(dto -> dto.getId().equals(entity.getId())));
        if (isRepited) {
            throw new DuplicateIdException("Identificador del vehículo ya existente");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> saveVehicles = dtos.stream()
                .map(dto -> mapper.convertValue(dto, Vehicle.class))
                .toList();

        boolean saved = vehicleRepository.saveAll(saveVehicles);
        if (!saved) {
            throw new CanNotSaveException("Datos mal formados o incompletos");
        }
        return dtos;
    }

    @Override
    public VehicleDto updateSpeed(Long id, Integer speed) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el vehículo"));
        vehicle.setMax_speed(String.valueOf(speed));
        vehicleRepository.update(vehicle);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> findAllByFuelType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.findAllByFuelType(type);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public String deleteById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el vehículo"));
        vehicleRepository.remove(vehicle);
        return "Vehiculo Eliminado con el ID: " + id;
    }

    @Override
    public List<VehicleDto> findByTransmissionType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.findByTransmissionType(type);
        if (vehicleList.isEmpty())
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        ObjectMapper mapper = new ObjectMapper();
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public VehicleDto updateFuelById(Long id, String fuel) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el vehículo."));
        vehicle.setFuel_type(fuel);
        vehicleRepository.update(vehicle);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

}

