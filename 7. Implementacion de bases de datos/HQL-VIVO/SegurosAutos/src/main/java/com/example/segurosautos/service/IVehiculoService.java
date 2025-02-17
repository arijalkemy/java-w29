package com.example.segurosautos.service;

import com.example.segurosautos.dto.response.MatriculaMarcaModeloVehiculoResponseDto;
import com.example.segurosautos.dto.response.PatenteMarcaVehiculoResponseDto;

import java.util.List;

public interface IVehiculoService {

    List<String> searchAllPatentes(String cantidadRuedasMax, String anioFabricacion);
    List<PatenteMarcaVehiculoResponseDto> searchAllPatentesAndMarca(String order, String by);
    List<MatriculaMarcaModeloVehiculoResponseDto> searchVehicleByPerdidaEconomica(Double perdidaEconomica);
}
