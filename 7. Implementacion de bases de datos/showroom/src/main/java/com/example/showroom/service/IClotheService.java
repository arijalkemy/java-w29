package com.example.showroom.service;

import com.example.showroom.dto.request.ClotheRequestDto;
import com.example.showroom.dto.response.ClotheResponseDto;

import java.util.List;

public interface IClotheService {
    ClotheResponseDto save(ClotheRequestDto clotheRequestDto);

    List<ClotheResponseDto> searchClothes();

    ClotheResponseDto searchClotheByCode();

    ClotheResponseDto modifyClotheByCode();
}
