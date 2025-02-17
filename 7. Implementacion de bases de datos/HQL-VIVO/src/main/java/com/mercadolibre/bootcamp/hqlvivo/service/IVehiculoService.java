package com.mercadolibre.bootcamp.hqlvivo.service;

import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteDto;
import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteModeloMarcaDto;
import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPerdidaTotalDto;

import java.util.List;

public interface IVehiculoService {

    List<VehiculoPatenteDto> searchAll();
    List<VehiculoPatenteModeloMarcaDto> searchAllByWheelCountAndCurrentYear();
    List<VehiculoPatenteModeloMarcaDto> searchAllByLossOver10000();
    VehiculoPerdidaTotalDto searchAllByLossOver10000WithTotal();

}
