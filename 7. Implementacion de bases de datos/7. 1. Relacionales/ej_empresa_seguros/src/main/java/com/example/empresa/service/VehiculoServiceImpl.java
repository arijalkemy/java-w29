package com.example.empresa.service;

import com.example.empresa.dto.PatenteAndMarcaDto;
import com.example.empresa.dto.PatenteMarcaModeloDto;
import com.example.empresa.dto.VehiculoDto;
import com.example.empresa.dto.VehiculoSiniestro;
import com.example.empresa.model.Vehiculo;
import com.example.empresa.repository.VehiculoRepository;
import com.example.empresa.util.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Override
    public List<String> getPatentes() {
        return vehiculoRepository.findAll()
                .stream()
                .map(Vehiculo::getPatente)
                .toList();
    }

    @Override
    public List<PatenteAndMarcaDto> getPatentesAndMarcas() {
        return vehiculoRepository.findAllPatentesAndMarcas()
                .stream()
                .map(v -> new PatenteAndMarcaDto(v.getPatente(), v.getMarca()))
                .toList();
    }

    @Override
    public List<String> getVehiculosCuatroRuedasAndCurrentYear() {
        return vehiculoRepository.findAllByRuedasAndYear(4, LocalDate.now().getYear())
                .stream()
                .map(Vehiculo::getPatente)
                .toList();
    }

    @Override
    public List<PatenteMarcaModeloDto> getVehiculosConSiniestroMayorA10000() {
        return vehiculoRepository.findAllByPerdidaEconomica(10000.0)
                .stream()
                .map(v -> new PatenteMarcaModeloDto(v.getPatente(), v.getMarca(), v.getModelo()))
                .toList();
    }

    @Override
    public List<VehiculoSiniestro> getVehiculosConSiniestroMayorA10000AndTotalPerdidaEconomica() {
        return vehiculoRepository.findTotalPerdidaEconomicaOfSiniestrosGreaterThan(10000.0)
                .stream()
                .map(arr -> new VehiculoSiniestro(Mapper.vehiculoDto((Vehiculo) arr[0]), (Long) arr[1]))
                .toList();
    }
}
