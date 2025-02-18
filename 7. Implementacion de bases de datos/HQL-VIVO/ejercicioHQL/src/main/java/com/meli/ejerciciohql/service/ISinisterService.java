package com.meli.ejerciciohql.service;

import com.meli.ejerciciohql.model.DTO.SinisterDto;
import com.meli.ejerciciohql.model.DTO.VehicleDtoByPatenteMarcaModelo;
import com.meli.ejerciciohql.model.Sinister;
import com.meli.ejerciciohql.model.Vehicle;

import java.util.List;

public interface ISinisterService {
    public List<SinisterDto> getSinisters();
    public void saveSinister(Sinister sinister);
    public void deleteSinister(Long id);
    public SinisterDto findSinister (Long id);
    List<VehicleDtoByPatenteMarcaModelo> getSinisterPerdeidaMayor();

}
