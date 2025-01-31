package com.thiagoschreck.local.ej_concensionaria_autos.service;

import com.thiagoschreck.local.ej_concensionaria_autos.dto.request.NewVehicleRequestDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.dto.response.NewVehicleResponseDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.dto.response.VehicleResponseDTO;

import java.util.List;

public interface IConcesionariaService {
    NewVehicleResponseDTO addVehicle(NewVehicleRequestDTO newVehicle);
    List<VehicleResponseDTO> getVehicles();
    List<VehicleResponseDTO> getVehiclesByManufacturingDate(String since, String to);
    List<VehicleResponseDTO> getVehiclesByPrice(String since, String to);
    VehicleResponseDTO getVehicleById(Integer id);
}
