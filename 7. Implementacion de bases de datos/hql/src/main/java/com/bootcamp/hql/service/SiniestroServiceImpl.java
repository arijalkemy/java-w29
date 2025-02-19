package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.SiniestroDto;
import com.bootcamp.hql.dto.VehiculoDto;
import com.bootcamp.hql.enity.Siniestro;
import com.bootcamp.hql.enity.Vehiculo;
import com.bootcamp.hql.repository.SiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SiniestroServiceImpl implements ISiniestroService{

    private final SiniestroRepository siniestroRepository;
    private final ModelMapper modelMapper;

    public SiniestroServiceImpl(SiniestroRepository siniestroRepository) {
        this.siniestroRepository = siniestroRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public SiniestroDto createSiniestro(SiniestroDto siniestroDto) {
        Siniestro siniestro = modelMapper.map(siniestroDto, Siniestro.class);
        Siniestro savedSiniestro = siniestroRepository.save(siniestro);
        return modelMapper.map(savedSiniestro, SiniestroDto.class);
    }

    @Override
    public SiniestroDto getSiniestro(Long id) {
        Optional<Siniestro> siniestro = siniestroRepository.findById(id);
        return siniestro.map(value -> modelMapper.map(value, SiniestroDto.class)).orElse(null);
    }

    public List<VehiculoDto> findByLosesGraterThan(int loses) {
        List<Siniestro> siniestros = siniestroRepository.findByLosesGraterThan(loses);
        return siniestros.stream().map(Siniestro::getVehiculo).map(vehiculo -> modelMapper.map(vehiculo, VehiculoDto.class)).toList();
    }

    public Long findTotalLosesGraterThan(int loses) {
        return siniestroRepository.findTotalLosesGraterThan(loses);
    }
}
