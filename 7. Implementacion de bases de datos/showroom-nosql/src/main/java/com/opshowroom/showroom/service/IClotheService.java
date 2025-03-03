package com.opshowroom.showroom.service;

import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.dto.request.ClotheDTO;

import java.util.List;

public interface IClotheService {

        List<Clothe> getClothes();

        ClotheDTO getClothe(Long code);

        List<ClotheDTO> getClothesBySize(String size);

        List<ClotheDTO> getClothesByWordInName(String word);

        Clothe createClothe(ClotheDTO clotheDto);

        ClotheDTO updateClothe(Long code, ClotheDTO clothe);

        ClotheDTO deleteClothe(Long code);
}

