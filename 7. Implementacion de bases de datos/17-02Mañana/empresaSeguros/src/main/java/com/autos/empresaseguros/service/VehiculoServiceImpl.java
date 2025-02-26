package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.model.Vehiculo;
import com.autos.empresaseguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
    public void saveVehicle(VehiculoDTO vehiculoDTO){
        Vehiculo vehic = mp.map(vehiculoDTO, Vehiculo.class);
        vehiculoRepository.save(vehic);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehiculoRepository.deleteById(id);
    }

    @Override
    public VehiculoDTO findVehicleById(Long id) {
        Vehiculo vehic = vehiculoRepository.findById(id).orElse(null);
        return mp.map(vehic, VehiculoDTO.class);
    }
}
