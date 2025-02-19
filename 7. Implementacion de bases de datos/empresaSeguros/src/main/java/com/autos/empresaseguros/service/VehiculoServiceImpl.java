package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.dto.VehiculoSiniestroDto;
import com.autos.empresaseguros.model.Siniestro;
import com.autos.empresaseguros.model.Vehiculo;
import com.autos.empresaseguros.model.VehiculoSiniestro;
import com.autos.empresaseguros.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<VehiculoDTO> listDTOs = listVehic.stream().map(v -> mp.map(v, VehiculoDTO.class)).toList();
        return listDTOs;
    }

    @Override
    public List<VehiculoDTO> searchPatentes() {
        return vehiculoRepository.findPatente()
                .stream()
                .map(v-> VehiculoDTO.builder().patente(v.getPatente()).build()).toList();
    }

    @Override
    public List<VehiculoDTO> searchPatentsAndBrandForYear() {

        return vehiculoRepository.findAllByPatentAndBrand()
                .stream()
                .map(v-> VehiculoDTO.builder().patente(v.getPatente()).marca(v.getMarca()).build()).toList();
    }

    @Override
    public List<VehiculoDTO> searchPatentsWithWheels() {
        return vehiculoRepository.findAllByPatentWithWheels()
                .stream()
                .map(v-> VehiculoDTO.builder().patente(v.getPatente()).build()).toList();
    }

    @Override
    public List<VehiculoDTO> searchVehiclesWithLoss() {
        return vehiculoRepository.findAllByPatentWithLoss()
                .stream()
                .map(v-> VehiculoDTO.builder().marca(v.getMarca()).patente(v.getPatente()).modelo(v.getModelo()).build()).toList();
    }

    @Override
    public List<VehiculoSiniestroDto> searchiniestrosVehiclesWithLoss() {
        List<Object[]> results = vehiculoRepository.findVehiclesWithLossMayorTo10000();

        return results.stream()
                .map(result -> {
                    VehiculoSiniestroDto dto = new VehiculoSiniestroDto();
                    dto.setPatente((String) result[0]);
                    dto.setMarca((String) result[1]);
                    dto.setModelo((String) result[2]);
                    dto.setPerdidaTotal((Double) result[3]);
                    return dto;
                })
                .toList();
    }
}
