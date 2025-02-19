package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.dto.VehiculoSiniestroDto;
import com.autos.empresaseguros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDTO> getAllVehicles();

    List<VehiculoDTO> searchPatentes();

    List<VehiculoDTO> searchPatentsAndBrandForYear();

    List<VehiculoDTO> searchPatentsWithWheels();

    List<VehiculoDTO> searchVehiclesWithLoss();

    List<VehiculoSiniestroDto> searchiniestrosVehiclesWithLoss();
}
