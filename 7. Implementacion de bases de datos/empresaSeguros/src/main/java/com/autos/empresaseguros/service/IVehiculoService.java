package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDTO> getAllVehicles();

    List<VehiculoDTO> searchPatentes();
}
