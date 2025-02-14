package com.example.empresa.service;

import com.example.empresa.dto.PatenteAndMarcaDto;
import com.example.empresa.dto.PatenteMarcaModeloDto;

import java.util.List;

public interface VehiculoService {
    List<String> getPatentes();

    List<PatenteAndMarcaDto> getPatentesAndMarcas();

    List<String> getVehiculosCuatroRuedasAndCurrentYear();

    List<PatenteMarcaModeloDto> getVehiculosConSiniestroMayorA10000();
}
