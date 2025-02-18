package com.meli.ejerciciohql.service;

import com.meli.ejerciciohql.model.DTO.SinisterDto;
import com.meli.ejerciciohql.model.DTO.VehicleDtoByPatenteMarcaModelo;
import com.meli.ejerciciohql.model.Sinister;
import com.meli.ejerciciohql.repository.ISinisterRepisotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SinisterServiceImp implements ISinisterService{
@Autowired
    ISinisterRepisotory sinisterRepisotory;
    @Override
    public List<SinisterDto> getSinisters() {
        List<Sinister> lista = sinisterRepisotory.findAll();
        return lista.stream()
                .map(sinister -> new SinisterDto(
                        sinister.getFecha(),
                        sinister.getPerdidaEconomica(),
                        sinister.getVehicle()
                )).collect(Collectors.toList());
    }

    @Override
    public void saveSinister(Sinister sinister) {

        sinisterRepisotory.save(sinister);
    }

    @Override
    public void deleteSinister(Long id) {

        sinisterRepisotory.deleteById(id);
    }

    @Override
    public SinisterDto findSinister(Long id) {
        Sinister sinister = sinisterRepisotory.findById(id).orElse(null);
        return new SinisterDto(sinister.getFecha(),sinister.getPerdidaEconomica(),sinister.getVehicle());
    }

    @Override
    public List<VehicleDtoByPatenteMarcaModelo> getSinisterPerdeidaMayor() {
        return sinisterRepisotory.getSinisterPerdeidaMayor().stream()
                .map(vehicle -> new VehicleDtoByPatenteMarcaModelo(vehicle.getPatente(), vehicle.getMarca(), vehicle.getModelo()))
                .collect(Collectors.toList());
    }
}
