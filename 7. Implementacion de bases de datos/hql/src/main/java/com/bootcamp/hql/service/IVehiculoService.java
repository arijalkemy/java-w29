package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.VehiculoDto;

import java.util.List;
import java.util.Map;

public interface IVehiculoService {
    public VehiculoDto createVehiculo(VehiculoDto vehiculoDto);
    public VehiculoDto getVehiculo(Long id);
    public List<Long> findAllPlates();
    public Map<Long, String> findLicensePlateAndBrand();
    public List<Long> findPlatesByVehicleWithMoreThanFourWheels();
}
