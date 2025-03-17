package com.example.showroom.service;

import com.example.showroom.dto.ClotheDto;

import java.util.List;

public interface IClotheService {
    void deleteClothe(Integer code);

    List<ClotheDto> getClothes(String name, String size);

    String createClothe(ClotheDto clotheDto);

    ClotheDto getClotheByCode(Integer code);

    String updateClothe(Integer code, ClotheDto clotheDto);
}
