package com.mercadolibre.bootcamp.hqlvivo.service;

import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteDto;
import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteModeloMarcaDto;
import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPerdidaTotalDto;
import com.mercadolibre.bootcamp.hqlvivo.model.Vehiculo;
import com.mercadolibre.bootcamp.hqlvivo.repository.SiniestroRepository;
import com.mercadolibre.bootcamp.hqlvivo.repository.VehiculoRepository;
import com.mercadolibre.bootcamp.hqlvivo.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final SiniestroRepository siniestroRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository, SiniestroRepository siniestroRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public List<VehiculoPatenteDto> searchAll() {
        return vehiculoRepository
                .findAll()
                .stream()
                .map(MapperUtils::vehiculoToVehiculoPatenteDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteModeloMarcaDto> searchAllByWheelCountAndCurrentYear() {
        return vehiculoRepository
                .findAll()
                .stream()
                .map(MapperUtils::vehiculoToVehiculoPatenteModeloMarcaDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteModeloMarcaDto> searchAllByLossOver10000() {
        return vehiculoRepository
                .findAllByLossOver10000()
                .stream()
                .map(MapperUtils::vehiculoToVehiculoPatenteModeloMarcaDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculoPerdidaTotalDto searchAllByLossOver10000WithTotal() {
        List<VehiculoPatenteModeloMarcaDto> vehiclesOver10000 = vehiculoRepository
                        .findAllByLossOver10000()
                        .stream()
                        .map(MapperUtils::vehiculoToVehiculoPatenteModeloMarcaDto)
                        .toList();
        Double sum = siniestroRepository.findTotalLossOver10000();

        return new VehiculoPerdidaTotalDto(vehiclesOver10000, sum);
    }
}
