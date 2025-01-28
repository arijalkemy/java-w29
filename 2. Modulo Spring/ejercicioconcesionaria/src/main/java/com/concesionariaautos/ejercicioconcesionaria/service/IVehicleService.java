package com.concesionariaautos.ejercicioconcesionaria.service;

import com.concesionariaautos.ejercicioconcesionaria.dto.request.VehicleRequestDto;
import com.concesionariaautos.ejercicioconcesionaria.dto.response.VehicleResponseDto;

import java.util.List;

public interface IVehicleService {
    VehicleResponseDto addVehicle(VehicleRequestDto vehicleRequestDto);

    List<VehicleResponseDto> findListVehicles();

    List<VehicleResponseDto> findListVehiclesForDateBuild(String since, String to);

    List<VehicleResponseDto> findListVehiclesForForPrices(String since, String to);

    VehicleResponseDto findVehicle(Long id);
}
