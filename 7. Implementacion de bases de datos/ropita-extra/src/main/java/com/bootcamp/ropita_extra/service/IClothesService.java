package com.bootcamp.ropita_extra.service;

import com.bootcamp.ropita_extra.dto.ClothesDto;

import java.util.List;

public interface IClothesService {
    String addClothes(ClothesDto clothesDto);
    List<ClothesDto> findAllClothes(String name);

    ClothesDto findClothesByCode(String code);

    ClothesDto updateClothes(String code, ClothesDto clothesDto);

    void deleteClothesByCode(String code);
}
