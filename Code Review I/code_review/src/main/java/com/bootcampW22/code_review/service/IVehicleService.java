package com.bootcampW22.code_review.service;

import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.dto.response.NewVehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    NewVehicleDto addVehicle(VehicleDto newVehicle);
}
