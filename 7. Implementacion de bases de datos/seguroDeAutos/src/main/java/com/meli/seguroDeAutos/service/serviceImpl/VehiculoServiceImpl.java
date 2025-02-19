package com.meli.seguroDeAutos.service.serviceImpl;

import com.meli.seguroDeAutos.dto.VehiculoDto;
import com.meli.seguroDeAutos.exception.AlreadyException;
import com.meli.seguroDeAutos.exception.NotFoundException;
import com.meli.seguroDeAutos.model.Vehiculo;
import com.meli.seguroDeAutos.repository.VehiculoRepository;
import com.meli.seguroDeAutos.service.interfazService.IVehiculoService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class VehiculoServiceImpl implements IVehiculoService {

    private final VehiculoRepository vehiculoRepo;
    private final ModelMapper modelMapper;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepo, ModelMapper modelMapper) {
        this.vehiculoRepo = vehiculoRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public VehiculoDto save(VehiculoDto vehiculoDto) {
        Optional<Vehiculo> vehiculo = vehiculoRepo.findVehiculoByPatente(vehiculoDto.getPatente());
        if(vehiculo.isPresent()){
            throw new AlreadyException("La patente del vehiculo ya existe");
        }
        vehiculoRepo.save(modelMapper.map(vehiculoDto, Vehiculo.class));
        return vehiculoDto;
    }

    @Override
    public VehiculoDto searchByPatente(Long patente) {
        Optional<Vehiculo> vehiculo = vehiculoRepo.findVehiculoByPatente(patente);
        if(vehiculo.isEmpty()){
            throw new NotFoundException("El vehiculo buscado no extste");
        }
        return modelMapper.map(vehiculo.get(), VehiculoDto.class);
    }

    @Override
    public List<VehiculoDto> searchAll() {
        List<Vehiculo> vehiculos = vehiculoRepo.findAll();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDto.class)).toList();
    }

    @Override
    public List<Long> searchAllPatentes() {
        return vehiculoRepo.findAllPatentes();
    }
}
