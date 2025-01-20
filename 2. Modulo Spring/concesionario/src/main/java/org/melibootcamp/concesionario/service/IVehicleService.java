package org.melibootcamp.concesionario.service;

import org.melibootcamp.concesionario.dto.request.VehicleRequestDto;
import org.melibootcamp.concesionario.dto.response.VehicleResponseDTO;
import org.melibootcamp.concesionario.dto.response.VehicleResponseUsedDto;
import org.melibootcamp.concesionario.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IVehicleService {

    VehicleResponseDTO createVehicle(VehicleRequestDto vehicleRequestDto);

    List<VehicleResponseUsedDto> getAllVehicles();

    List<VehicleResponseUsedDto> getAllVehiclesByDate(LocalDate since, LocalDate to);

    List<VehicleResponseUsedDto> getAllVehiclesByPrices(Double since, Double to);

    VehicleResponseDTO getVehicleById(Integer id);
}
