package com.meli.seguroDeAutos.service.interfazService;

import com.meli.seguroDeAutos.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {
    VehiculoDto save(VehiculoDto vehiculoDto);
    VehiculoDto searchByPatente(Long patente);
    List<VehiculoDto> searchAll();
    List<Long> searchAllPatentes();
}
