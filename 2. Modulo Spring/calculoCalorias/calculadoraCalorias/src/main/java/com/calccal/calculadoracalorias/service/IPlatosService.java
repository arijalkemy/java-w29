package com.calccal.calculadoracalorias.service;

import com.calccal.calculadoracalorias.dto.IngredienteDTO;
import com.calccal.calculadoracalorias.dto.PlatoDTO;

import java.util.List;

public interface IPlatosService {
    List<IngredienteDTO> findAllIngr();
    List<PlatoDTO> findAllPlatos();
    String findCaloriasPorPlato(String nombrePlato);

    List<IngredienteDTO> findInfoPorPlato(String nombrePlato);
    IngredienteDTO findIngredienteConMasCalorias(String nombrePlato);
}
