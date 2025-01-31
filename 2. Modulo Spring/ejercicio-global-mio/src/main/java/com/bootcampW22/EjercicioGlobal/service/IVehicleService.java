package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageCapacityDTO;
import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {
    ResponseEntity<VehicleDTO> addVehicle(VehicleDTO vehicleDto);
    ResponseEntity<List<VehicleDTO>> addVehicle(List<VehicleDTO> vehicleDto);
    ResponseEntity<List<VehicleDTO>> findAll(String brand, String color, Integer since, Integer to, Integer year, String fuelType, String transmission, Double minLength, Double maxLength, Double minWidth, Double maxWidth, Double minWeight, Double maxWeight);

    ResponseEntity<List<AverageSpeedDTO>> getAverageSpeed(String brands);

    ResponseEntity<List<AverageCapacityDTO>> getAverageCapacity(String brands);

    ResponseEntity<VehicleDTO> updateVehicle(Long id, VehicleDTO vehicleDTO);

    ResponseEntity<VehicleDTO> deleteVehicle(Long id);
}
