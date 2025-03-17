package com.example.seguros.service;

import com.example.seguros.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> searchAllPatentsRegistered();
    List<VehicleDTO> searchAllPatentsAndBrandOrderByYear();
    List<VehicleDTO> searchPatentsAbove4WheelsCurrentYear();
    List<VehicleDTO> searchVehicleWithLostAbove10000();
    List<VehicleDTO> getVehicleWithLostAbove10000WithTotal();
}
