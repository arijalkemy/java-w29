package com.example.calorias.service;

import com.example.calorias.dtos.PlateRequestDto;
import com.example.calorias.dtos.PlateResponseDto;

import java.util.List;

public interface PlateService {
    PlateResponseDto getPlateInfo(PlateRequestDto plateRequestDTO);

    List<PlateResponseDto> getBatchPlateInfo(List<PlateRequestDto> plateRequestDTOs);
}
