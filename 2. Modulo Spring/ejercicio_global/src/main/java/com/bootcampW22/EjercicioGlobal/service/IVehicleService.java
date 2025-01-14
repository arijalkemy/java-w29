package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    Vehicle addOne(VehicleDto dto);

    List<VehicleDto> findAllByColorAndYear(String color, Integer year);
}
