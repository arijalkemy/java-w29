package org.bootcamp.codereviewtest.service;

import org.bootcamp.codereviewtest.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    List<VehicleDto> searchByBrandAndBetweenYears(String brand,
                                                  Integer startYear,
                                                  Integer endYear);
}
