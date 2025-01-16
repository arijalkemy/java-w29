package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {

    List<VehicleDto> searchAllVehicles();

    VehicleDto addOne(VehicleDto dto);

    List<VehicleDto> findAllByColorAndYear(String color, Integer year);

    List<VehicleDto> findAllByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear);

    List<VehicleDto> findAllByDimensions(String length, String width);

    List<VehicleDto> findAllByWeight(Double weightMin, Double weightMax);
}
