package com.meli.concesionarioseguros.service;

import com.meli.concesionarioseguros.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<String> findAllVehiclesPatents(Integer minWheels, Integer year) {
        return vehiculoRepository.findAllVehicularPatents(minWheels, year);
    }

    @Override
    public List<HashMap<String, String>> findAllVehiclesPatentsAndBrands(String sortOrder) {
        return List.of();
    }

    @Override
    public List<HashMap<String, String>> findVehiclesByAmountAccidentsDetails(String minLoss) {
        return List.of();
    }

    @Override
    public List<HashMap<String, String>> findVehiclesByAmountAccidentSummary(String minLoss) {
        return List.of();
    }
}
