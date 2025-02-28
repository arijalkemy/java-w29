package com.example.vehicles.service;

import com.example.vehicles.dto.VehicleDTO;
import com.example.vehicles.model.Vehicle;
import com.example.vehicles.repository.IVehicleRepository;
import com.example.vehicles.utils.VehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService {
    private final IVehicleRepository vehicleRepository;

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return parseList(vehicleRepository.findAll());
    }

    @Override
    public List<String> getAllPatents() {
        return vehicleRepository.getAllPatents();
    }

    @Override
    public List<Object[]> getAllPatentsAndBrandsOrderByYear() {
        return vehicleRepository.getAllPatentsAndBrandsOrderByYear();
    }

    @Override
    public List<Object[]> getPatentsFromVehiclesWithFourWheelsAndCurrentYear() {
        return vehicleRepository.getPatentsFromVehiclesWithFourWheelsAndCurrentYear();
    }

    @Override
    public List<Object[]> getPatentBrandModelVehiclesWithOneAccidentAndLoss() {
        return vehicleRepository.getPatentBrandModelVehiclesWithOneAccidentAndLoss();
    }

    @Override
    public List<Object[]> getPatentBrandModelVehiclesWithOneAccidentAndLossAndSum() {
        return vehicleRepository.getPatentBrandModelVehiclesWithOneAccidentAndLossAndSum();
    }

    private List<VehicleDTO> parseListFromObjectList(List<Object[]> vehicles) {
        return vehicles.stream()
                .map(VehicleMapper.INSTANCE::objectToVehicleDTO)
                .toList();
    }

    private List<VehicleDTO> parseList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(VehicleMapper.INSTANCE::vehicleToVehicleDTO)
                .toList();
    }
}
