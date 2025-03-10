package org.example.ej_siniestros.service;

import org.example.ej_siniestros.dto.PatenteDto;
import org.example.ej_siniestros.dto.PatenteMarcaDto;
import org.example.ej_siniestros.dto.PatenteMarcaModeloDto;
import org.example.ej_siniestros.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {

    List<String> getallPatentes();

    List<PatenteMarcaDto> getAllPatentesAndBrandByAnio();

    List<VehiculoDto> findVehiclesWithAccidentEconomicLossGreaterThan10000();

}
