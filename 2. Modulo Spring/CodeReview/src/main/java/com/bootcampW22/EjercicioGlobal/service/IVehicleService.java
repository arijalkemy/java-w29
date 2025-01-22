package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    Vehicle addVehicle(VehicleDto vehicleDto);

    Optional<VehicleDto> findVehicleById(Long id);

    List<VehicleDto> getVehicleByColorAndYear(String color, int year);

    List<VehicleDto> getVehicleByBrandAndYears(String brand, int starYear, int endYear);

    Double getSpeedByBrand(String brand);

    List<VehicleDto> addAllVehicles(List<VehicleDto> vehicles);

    VehicleDto updateSpeed(Long id, Double newSpeed);

    List<VehicleDto> getVehicleByFuel(String fuel);

    ResponseDto deleteById(Long id);

    List<VehicleDto> findByTrasmissionType(String trasmisison);

    ResponseDto updateFuel(Long id, String fuel);

    List<VehicleDto> findByMedidas(Double minWidth, Double maxWidth, Double minHeight, Double maxHeight);

    Double avgPersonByBrand(String brand);

    List<VehicleDto> getVehicleByWeight(Double minWeight, Double maxWeight);


}
