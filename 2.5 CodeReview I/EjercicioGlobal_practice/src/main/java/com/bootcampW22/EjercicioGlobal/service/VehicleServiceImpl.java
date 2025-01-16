package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService{

    private final IVehicleRepository vehicleRepository;

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
    public List<VehicleDto> searchVehiclesByWeight(Double min, Double max) {
      List<Vehicle> vehicles = vehicleRepository.findByWeightRange(min, max);
      if(vehicles.isEmpty()) throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
      ObjectMapper om = new ObjectMapper();
      return vehicles.stream()
        .map(vehicle -> om.convertValue(vehicle, VehicleDto.class))
        .toList();
    }

}
