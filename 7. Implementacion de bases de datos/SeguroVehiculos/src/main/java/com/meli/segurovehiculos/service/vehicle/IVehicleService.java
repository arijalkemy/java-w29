package com.meli.segurovehiculos.service.vehicle;

import com.meli.segurovehiculos.dto.VehicleDto;
import com.meli.segurovehiculos.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> getAllVehicles();
    List<VehicleDto> getAllPlatesVehicles();
    List<VehicleDto> getAllYears();
    List<VehicleDto> getAllYearsWithWheels(int year);
}
