package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageVehiclesDto;
import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    //[US-0001]
    ResponseEntity<ExceptionDto> createVehiculo(Vehicle vehicle);

    //[US-0002]
    List<VehicleDto> searchVehiclesByColorByYear(String color, int year);

    //[US-0003]
    List<VehicleDto> searchVehiclesByBrandByBeetweenYears(String brand, int startYear, int endYear);

    //[US-0004]
    AverageVehiclesDto calculateAverageSpeedByBrand(String brand);

    //[US-0005]
    ResponseEntity<ExceptionDto> createBatchVehicles(List<Vehicle> vehicles);

    //[US-0006]
    ResponseEntity<ExceptionDto> updateMaxSpeed(Long id, String updateSpeed);

    //[US-0007]
    List<VehicleDto> searchByFuelType(String type);

    //[US-0012]
    List<VehicleDto> searchVehiclesByDimensions(String lengthRange, String widthRange);


}
