package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDTO> getAllVehicles();
    void saveVehicle(VehiculoDTO vehiculoDTO);
    void deleteVehicle(Long id);
    VehiculoDTO findVehicleById(Long id);
}
