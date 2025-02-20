package com.org.meli.showroom.service;

import com.org.meli.showroom.dto.GarmentDto;

import java.util.List;

public interface IGarmentService {
    GarmentDto saveGarment(GarmentDto garmentDto);
    List<GarmentDto> getAllGarments();
    GarmentDto getGarmentById(Long id);
    GarmentDto updateGarment(Long id, GarmentDto garmentDto);
    GarmentDto deleteGarment(Long id);
    List<GarmentDto> getGarmentsBySize(String size);
    List<GarmentDto> getGarmentsByName(String name);
}
