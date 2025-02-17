package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.PatenteAndMarcaDTO;
import com.autos.empresaseguros.dto.PatenteDTO;
import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.model.Vehiculo;
import com.autos.empresaseguros.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Objects;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;

    final ModelMapper mp = new ModelMapper();

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<VehiculoDTO> getAllVehicles() {
        List<Vehiculo> listVehic = vehiculoRepository.findAll();
        return listVehic.stream().map(v -> mp.map(v, VehiculoDTO.class)).toList();
    }

    @Override
    public List<PatenteDTO> getAllPatentes() {
        List<Vehiculo> listVehic = vehiculoRepository.findAll();
        return listVehic.stream().map(v -> mp.map(v, PatenteDTO.class)).toList();
    }

    @Override
    public List<PatenteAndMarcaDTO> getPatenteAndMarcaOrderedByYear() {
        List<Vehiculo> listVehic = vehiculoRepository.getPatenteAndMarcaOrderedByYear();
        return listVehic.stream().map(v -> mp.map(v, PatenteAndMarcaDTO.class)).toList();
    }

    @Override
    public List<PatenteDTO> getPatenteVehiculosConMas4Ruedas() {
        List<Vehiculo> listVehic = vehiculoRepository.getPatenteVehiculosConMas4Ruedas();
        return listVehic.stream().map(v -> mp.map(v, PatenteDTO.class)).toList();
    }
}
