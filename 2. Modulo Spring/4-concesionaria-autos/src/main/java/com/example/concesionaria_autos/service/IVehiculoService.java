package com.example.concesionaria_autos.service;

import com.example.concesionaria_autos.dto.request.VehiculoDTO;
import com.example.concesionaria_autos.dto.response.VehiculoResponseDTO;
import com.example.concesionaria_autos.dto.response.VehiculoWServicesDTO;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {
    VehiculoResponseDTO agregarVehiculo(VehiculoDTO vehiculoDTO);

    List<VehiculoWServicesDTO> getVehicles();

    List<VehiculoWServicesDTO> searchVehiclesByYearRange(String since, String to);

    List<VehiculoWServicesDTO> searchVehiclesBypriceRange(String since, String to);

    VehiculoWServicesDTO searchVehicleById(Long id);
}
