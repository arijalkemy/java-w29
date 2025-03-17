package com.example.insurance.service;

import com.example.insurance.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> searchAllPatentsRegistered();
    List<VehicleDTO> searchAllPatentsAndBrandOrderByYear();
    List<VehicleDTO> searchPatentsAbove4WheelsCurrentYear();
    List<VehicleDTO> searchVehicleWithLostAbove10000();
    List<VehicleDTO> getVehicleWithLostAbove10000WithTotal();
}
