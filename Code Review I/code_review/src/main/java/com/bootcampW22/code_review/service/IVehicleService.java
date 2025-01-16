package com.bootcampW22.code_review.service;

import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.dto.request.UpdateVehicleDto;
import com.bootcampW22.code_review.dto.response.ResponseVehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    ResponseVehicleDto addVehicle(VehicleDto newVehicle);
    ResponseVehicleDto addVehicles(List<VehicleDto> newVehicles);
    VehicleDto getVehicleById(Long id);
    List<VehicleDto> getByColorAndYear(String color, Integer year);
    List<VehicleDto> getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);
    List<VehicleDto> getByWeight(double weightMin, double weightMax);
    List<VehicleDto> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth);
    ResponseVehicleDto updateFuel(Long id, UpdateVehicleDto vehicle);
    ResponseVehicleDto getAverageCapacityByBrand(String brand);
}
