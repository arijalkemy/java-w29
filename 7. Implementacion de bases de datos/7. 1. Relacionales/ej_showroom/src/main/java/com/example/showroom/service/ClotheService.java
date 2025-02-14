package com.example.showroom.service;

import com.example.showroom.dto.ClotheDto;

import java.util.List;

public interface ClotheService {
    List<ClotheDto> getClothes(String name, String size);

    String createClothe(ClotheDto clotheDto);

    ClotheDto getClotheByCode(Integer code);

    ClotheDto updateClothe(Integer code, ClotheDto clotheDto);

    void deleteClothe(Integer code);
}
