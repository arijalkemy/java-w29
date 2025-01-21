package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.request.MaxSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.response.GenericResponseDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    GenericResponseDto updateMaxSpeed(Long id, MaxSpeedDto maxSpeedDto);
}
