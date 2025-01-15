package com.bootcampW22.code_review.service;

import com.bootcampW22.code_review.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
}
