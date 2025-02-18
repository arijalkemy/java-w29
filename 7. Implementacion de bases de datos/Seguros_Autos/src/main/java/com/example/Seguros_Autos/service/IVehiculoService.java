package com.example.Seguros_Autos.service;

import com.example.Seguros_Autos.DTO.PatenteMarcaDTO;
import com.example.Seguros_Autos.DTO.VehiculoSiniestroDTO;
import com.example.Seguros_Autos.DTO.VehiculoSiniestroTotalLossDTO;

import java.util.List;

public interface IVehiculoService {

    List<String> findAllPatentes();

    List<PatenteMarcaDTO> getPatentesAndMarcasOrderedByAnioFabricacion();

    List<String> getVehiculosCuatroRuedasAndCurrentYear();

    List<VehiculoSiniestroDTO> findPatenteMarcaModeloBySiniestroWithLossGreaterThan10000();

    List<VehiculoSiniestroTotalLossDTO> findPatenteMarcaModeloAndTotalLossBySiniestroWithLossGreaterThan10000();
}

