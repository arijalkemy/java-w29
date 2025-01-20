package com.bootcamp.cardealership.service;

import com.bootcamp.cardealership.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    VehicleDTO save(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAll();

    List<VehicleDTO> getBetweenDates(LocalDate from, LocalDate to);

    List<VehicleDTO> getBetweenPrices(Double from, Double to);

    VehicleDTO findById(String id);
}
