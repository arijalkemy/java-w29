package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.VehiculoDto;
import com.bootcamp.hql.enity.Vehiculo;
import com.bootcamp.hql.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public VehiculoDto createVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = modelMapper.map(vehiculoDto, Vehiculo.class);
        Vehiculo savedVehiculo =vehiculoRepository.save(vehiculo);
        return modelMapper.map(savedVehiculo, VehiculoDto.class);
    }

    @Override
    public VehiculoDto getVehiculo(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        return vehiculo.map(value -> modelMapper.map(value, VehiculoDto.class)).orElse(null);
    }

    public List<Long> findAllPlates() {
        return vehiculoRepository.findAllPlates();
    }

    public Map<Long, String> findLicensePlateAndBrand() {
        return vehiculoRepository.findLicensePlateAndBrand();
    }

    public List<Long> findPlatesByVehicleWithMoreThanFourWheels() {
        return vehiculoRepository.findPlatesByVehicleWithMoreThanFourWheels();
    }
}
