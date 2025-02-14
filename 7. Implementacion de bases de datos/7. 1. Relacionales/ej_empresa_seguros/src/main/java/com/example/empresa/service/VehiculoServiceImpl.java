package com.example.empresa.service;

import com.example.empresa.dto.PatenteAndMarcaDto;
import com.example.empresa.dto.PatenteMarcaModeloDto;
import com.example.empresa.repository.VehiculoRepository;
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
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<PatenteAndMarcaDto> getPatentesAndMarcas() {
        List<String[]> patentesAndMarcas = vehiculoRepository.findAllPatentesAndMarcas();
        return patentesAndMarcas.stream()
                .map(arr -> new PatenteAndMarcaDto(arr[0], arr[1]))
                .toList();
    }

    @Override
    public List<String> getVehiculosCuatroRuedasAndCurrentYear() {
        return vehiculoRepository.findAllByRuedasAndYear(4, LocalDate.now().getYear());
    }

    @Override
    public List<PatenteMarcaModeloDto> getVehiculosConSiniestroMayorA10000() {
        return vehiculoRepository.findAllByPerdidaEconomica(10000)
                .stream()
                .map(arr -> new PatenteMarcaModeloDto(arr[0], arr[1], arr[2]))
                .toList();
    }
}
