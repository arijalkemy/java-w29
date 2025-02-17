package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.PatenteAndMarcaDTO;
import com.autos.empresaseguros.dto.PatenteDTO;
import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDTO> getAllVehicles();
    List<PatenteDTO> getAllPatentes();
    List<PatenteAndMarcaDTO> getPatenteAndMarcaOrderedByYear();
    List<PatenteDTO> getPatenteVehiculosConMas4Ruedas();
}
