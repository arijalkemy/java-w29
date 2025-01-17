package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IVehicleService {

    List<VehicleDto> searchAllVehicles();

    VehicleDto addOne(VehicleDto dto);

    List<VehicleDto> findAllByColorAndYear(String color, Integer year);

    List<VehicleDto> findAllByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);

    List<VehicleDto> findAllByDimensions(String length, String width);

    List<VehicleDto> findAllByWeight(Double weightMin, Double weightMax);

    Double getAverageCapacityOfBrand(String brand);

    Double getAverageSpeedOfBrand(String brand);

    List<VehicleDto> addVehicles(List<VehicleDto> vehicles);

    VehicleDto updateSpeed(Long id, Integer speed);

    List<VehicleDto> findAllByFuelType(String type);

    String deleteById(Long id);

    List<VehicleDto> findByTransmissionType(String type);

    VehicleDto updateFuelById(Long id, String fuel);
}
