package com.meli.segurovehiculos.service.vehicle;

import com.meli.segurovehiculos.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> getAllVehicles();
    List<String> getAllPlatesVehicles();
    List<Object[]> getAllYears();
    List<Object[]> getAllYearsWithWheels(int year);
}
