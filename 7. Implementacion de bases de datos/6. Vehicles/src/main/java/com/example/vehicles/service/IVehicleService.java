package com.example.vehicles.service;

import com.example.vehicles.dto.VehicleDTO;

import java.util.List;
import java.util.Objects;

public interface IVehicleService {
    List<VehicleDTO> getAllVehicles();
    List<String> getAllPatents();
    List<Object[]> getAllPatentsAndBrandsOrderByYear();
    List<Object[]> getPatentsFromVehiclesWithFourWheelsAndCurrentYear();
    List<Object[]> getPatentBrandModelVehiclesWithOneAccidentAndLoss();
    List<Object[]> getPatentBrandModelVehiclesWithOneAccidentAndLossAndSum();
}
